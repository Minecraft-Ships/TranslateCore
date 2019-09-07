package org.core.command.argument;

import org.core.exceptions.NotEnoughArguments;
import org.core.source.command.CommandSource;

import java.io.IOException;
import java.util.*;

public class CommandContext implements Iterator<String>{

    protected String[] rawArguments;
    protected int target = 0;
    protected List<ArgumentContext<?>> argumentProcessors = new ArrayList<>();
    protected CommandSource source;
    protected boolean tab = true;

    public CommandContext(CommandSource source, Collection<ArgumentContext<?>> collection, String... arguments){
        this.rawArguments = arguments;
        this.argumentProcessors.addAll(collection);
        this.source = source;
    }

    public CommandSource getSource(){
        return this.source;
    }

    public String[] getRawArguments(){
        return this.rawArguments;
    }

    public List<ArgumentContext<?>> getProcessors(){return this.argumentProcessors;}

    public void validate() throws NotEnoughArguments {
        List<ArgumentContext<?>> list = new ArrayList<>();
        for(ArgumentContext<?> a : this.argumentProcessors){
            try {
                a.parse(this);
            }catch (NotEnoughArguments e1){
                e1.printStackTrace();
                throw e1;
            } catch (ArrayIndexOutOfBoundsException | IOException e) {
                list.add(a);
            }
        }
        if(list.isEmpty()){
            return;
        }
        throw new NotEnoughArguments(list);
    }

    public boolean isForTabComplete(){
        return this.tab;
    }

    public void setForTabComplete(boolean check){
        this.tab = check;
    }

    public List<String> suggests(){
        int originalTarget = this.target;
        this.target = 0;
        for(ArgumentContext<?> argument : this.argumentProcessors){
            int safeTarget = this.target;
            try {
                argument.parse(this);
            /*}catch (ArrayIndexOutOfBoundsException e1){
                String[] args = new String[this.rawArguments.length - safeTarget];
                for(int A = safeTarget; A < this.rawArguments.length; A++){
                    args[A] = this.rawArguments[A];
                }
                this.target = originalTarget;
                return argument.getSuggestions(this, args);
            } catch (IOException e) {
                this.target = safeTarget;
            }*/
            }catch (ArrayIndexOutOfBoundsException | IOException e1){
                String[] args = new String[this.rawArguments.length - safeTarget];
                for(int A = safeTarget; A < this.rawArguments.length; A++){
                    args[A] = this.rawArguments[A];
                }
                this.target = originalTarget;
                return argument.getSuggestions(this, args);
            }
        }
        this.target = originalTarget;
        return new ArrayList<>();
    }

    public <V> Optional<V> getArgumentValue(String id, Class<ArgumentContext<V>> clazz){
        return getArgumentValue(id);
    }

    @SuppressWarnings("unchecked")
    public <V> Optional<V> getArgumentValue(String id){
        int originalTarget = this.target;
        this.target = 0;
        for(ArgumentContext<?> argument : this.argumentProcessors){
            int safeTarget = this.target;
            try {
                Object value = argument.parse(this);
                if (argument.getId().equals(id)) {
                    this.target = originalTarget;
                    return Optional.of((V) value);
                }
            }catch (ArrayIndexOutOfBoundsException e1){
                this.target = originalTarget;
                return Optional.empty();
            } catch (IOException e) {
                this.target = safeTarget;
            }
        }
        this.target = originalTarget;
        return Optional.empty();
    }

    @Override
    public boolean hasNext() {
        return this.rawArguments.length < target;
    }

    @Override
    public String next() {
        String ret = this.rawArguments[this.target];
        this.target++;
        return ret;
    }
}
