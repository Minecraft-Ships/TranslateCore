package org.core.command.argument;

import org.core.CorePlugin;
import org.core.command.argument.arg.child.ChildArgument;
import org.core.command.argument.arg.child.ChildContextEntry;
import org.core.command.argument.arg.generic.optional.OptionalArgument;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.*;

public class CommandContext {

    public static class CommandArgumentContext {

        private List<CommandArgumentEntry<?>> entries = new ArrayList<>();
        private CommandSource source;

        public CommandArgumentContext(CommandSource source, Collection<CommandArgumentEntry<?>> collection){
            this.entries.addAll(collection);
            this.source = source;
        }

        public CommandSource getSource(){
            return this.source;
        }

        public List<CommandArgumentEntry<?>> getEntries(){
            return this.entries;
        }

        private Optional<CommandArgumentEntry<?>> getEntry(String id, CommandArgumentEntry<?> entry){
            if(id.equals(entry.getArgument().getId())){
                return Optional.of(entry);
            }
            if(entry instanceof ChildContextEntry){
                ChildContextEntry context = (ChildContextEntry) entry;
                ChildArgument argument = context.getArgument();
                for (CommandArgumentEntry<?> entry1 : context.getValue().get().entries){
                    Optional<CommandArgumentEntry<?>> opEntry = this.getEntry(id, entry1);
                    if(opEntry.isPresent()){
                        return opEntry;
                    }
                }
            }
            return Optional.empty();
        }

        public <V extends Object, T extends CommandArgument<V>> Optional<CommandArgumentEntry<T>> get(String id){
            for(CommandArgumentEntry<?> entry : this.entries){
                Optional<CommandArgumentEntry<?>> opArg = this.getEntry(id, entry);
                if(opArg.isPresent()){
                    CommandArgumentEntry<?> entry1 = opArg.get();
                    return Optional.of((CommandArgumentEntry<T>)entry1);
                }
            }
            return Optional.empty();
        }

        public <V> Optional<V> getValue(String id){
            Optional<CommandArgumentEntry<CommandArgument<Object>>> opEntry = this.get(id);
            if(!opEntry.isPresent()){
                return Optional.empty();
            }
            return (Optional<V>) opEntry.get().getValue();
        }
    }

    public static class CommandArgumentEntry<E>{

        private CommandArgument<E> arg;
        private int starting;
        private int end;
        private E entry;

        public CommandArgumentEntry(CommandArgument<E> entry, int starting, int end, E value){
            this.arg = entry;
            this.starting = starting;
            this.end = end;
            this.entry = value;
        }

        public CommandArgument<E> getArgument(){
            return this.arg;
        }

        public int getStarting(){
            return this.starting;
        }

        public int getEnding(){
            return this.end;
        }

        public Optional<E> getValue(){
            return Optional.ofNullable(this.entry);
        }

    }

    private List<CommandArgument<?>> arguments = new ArrayList<>();

    public CommandContext(CommandArgument<?>... array){
        this(Arrays.asList(array));
    }

    public CommandContext(Collection<CommandArgument<?>> collection){
        this.arguments.addAll(collection);
    }

    public CommandContext(CommandContext... contexts){
        for(CommandContext context : contexts){
            context.arguments.stream().filter(a -> !(a instanceof ChildArgument)).forEach(a -> this.arguments.add(a));
        }
    }

    public List<CommandArgument<?>> getArguments(){
        return this.arguments;
    }

    public CommandArgumentContext run(CommandSource source, String... words) throws IOException {
        if(this.arguments.isEmpty()){
            throw new IOException("No argument found in context");
        }
        List<CommandArgumentEntry<?>> arguments = new ArrayList<>();
        List<CommandArgument<?>> args = new ArrayList<>(this.arguments);
        List<CommandArgument<?>> suggest = new ArrayList<>();
        int startWord = 0;
        int offset = 0;
        while(startWord < words.length){
            if((offset) >= args.size()){
                return new CommandArgumentContext(source, arguments);
            }
            String target = words[startWord];
            CommandArgument<?> arg = args.get(offset);
            try {
                CommandArgumentEntry<?> cmdArg = arg.run(this, source, startWord, words);
                arguments.add(cmdArg);
                args.remove(0);
                startWord = cmdArg.end;
                suggest.clear();
            }catch (IOException e){
                if(arg instanceof OptionalArgument){
                    offset++;
                    continue;
                }
                throw e;
            }
        }
        if(args.isEmpty()){
            throw new IOException("Invalid arguments");
        }
        return new CommandArgumentContext(source, arguments);
    }

    public Set<String> getSuggestions(CommandSource source, String... words){
        if(this.arguments.isEmpty()){
            return Collections.EMPTY_SET;
        }
        List<CommandArgumentEntry<?>> arguments = new ArrayList<>();
        List<CommandArgument<?>> args = new ArrayList<>(this.arguments);
        List<CommandArgument<?>> suggest = new ArrayList<>();
        int startWord = 0;
        int offset = 0;
        while(startWord < words.length){
            if((offset) >= args.size()){
                Set<String> suggestions = new HashSet<>();
                final int finalStartWord = startWord;
                suggest.stream().forEach(a -> suggestions.addAll(a.getSuggestions(source, finalStartWord, words)));
                return suggestions;
            }
            String target = words[startWord];
            CommandArgument<?> arg = args.get(offset);
            try {
                if(arg instanceof ChildArgument){
                    return arg.getSuggestions(source, startWord, words);
                }
                CommandArgumentEntry<?> cmdArg = arg.run(this, source, startWord, words);
                if(cmdArg.starting == cmdArg.end && arg instanceof OptionalArgument){
                    offset++;
                    suggest.add(arg);
                    continue;
                }
                arguments.add(cmdArg);
                args.remove(0);
                startWord = cmdArg.end;
                suggest.clear();
            }catch (IOException e){
                Set<String> suggestions = arg.getSuggestions(source, startWord, words);
                final int finalStartWord = startWord;
                suggest.stream().forEach(a -> suggestions.addAll(a.getSuggestions(source, finalStartWord, words)));
                return suggestions;
            }
        }
        if(args.isEmpty()){
            return Collections.EMPTY_SET;
        }
        return args.get(0).getSuggestions(source, 0, "");
    }
}
