package org.core.command.argument;

import org.core.command.BaseCommandLauncher;
import org.core.command.ChildArgumentCommandLauncher;
import org.core.entity.living.human.player.LivePlayer;
import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.CommandSource;
import org.core.source.viewer.CommandViewer;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public abstract class ArgumentCommandLauncher implements BaseCommandLauncher {

    public Set<ChildArgumentCommandLauncher> commands = new HashSet<>();

    public ArgumentCommandLauncher(ChildArgumentCommandLauncher... arguments){
        this(Arrays.asList(arguments));
    }

    public ArgumentCommandLauncher(Collection<ChildArgumentCommandLauncher> arguments){
        this.commands.addAll(arguments);
    }

    @Override
    public boolean run(CommandSource source, String... args) {
        if(args.length == 0){
            if(!(source instanceof CommandViewer)){
                return false;
            }
            CommandViewer viewer = (CommandViewer)source;
            viewer.sendMessagePlain("----[Commands]----");
            this.commands.stream().filter(c -> {
                if(!(c instanceof LivePlayer)){
                    return true;
                }
                Optional<String> opPermission = c.getPermission();
                if(!opPermission.isPresent()){
                    return false;
                }
                return ((LivePlayer)c).hasPermission(opPermission.get());
            }).forEach(c -> viewer.sendMessagePlain(c.getUsage(viewer) + ": " + c.getDescription()));
            return true;
        }
        Optional<ChildArgumentCommandLauncher> opcmd = this.commands.stream().filter(a -> args[0].equalsIgnoreCase(a.getName())).findAny();
        if(!opcmd.isPresent()){
            return false;
        }
        String[] args1 = new String[args.length - 1];
        for(int A =  1; A < args.length; A++){
            args1[A-1] = args[A];
        }
        try {
            return opcmd.get().run(source, args1);
        } catch (NotEnoughArguments e) {
            if(!(source instanceof CommandViewer)){
                return false;
            }
            ((CommandViewer) source).sendMessagePlain(e.getMessage());
            return false;
        } catch (Throwable e1){
            if(!(source instanceof CommandViewer)){
                return false;
            }
            ((CommandViewer) source).sendMessagePlain("Something went wrong, check console: " + e1.getMessage());
            return false;
        }
    }

    @Override
    public List<String> tab(CommandSource source, String... args) {
        if(args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase(""))){
            List<String> list = new ArrayList<>();
            this.commands.stream().filter(c -> {
                if(!(c instanceof LivePlayer)){
                    return true;
                }
                Optional<String> opPermission = c.getPermission();
                if(!opPermission.isPresent()){
                    return true;
                }
                return ((LivePlayer)c).hasPermission(opPermission.get());
            }).forEach(c -> list.add(c.getName()));
            return list;
        }
        Optional<ChildArgumentCommandLauncher> opcmd = this.commands.stream().filter(a -> args[0].equalsIgnoreCase(a.getName())).findAny();
        if(!opcmd.isPresent()){
            List<String> list = new ArrayList<>();
            this.commands.stream().filter(c -> c.getName().startsWith(args[0])).forEach(c -> list.add(c.getName()));
            return list;
        }
        String[] args1 = new String[args.length - 1];
        for(int A =  1; A < args.length; A++){
            args1[A-1] = args[A];
        }
        return opcmd.get().tab(source, args1);
    }
}
