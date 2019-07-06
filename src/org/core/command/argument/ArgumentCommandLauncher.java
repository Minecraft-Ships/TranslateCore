package org.core.command.argument;

import org.core.command.BaseCommandLauncher;
import org.core.command.ChildArgumentCommandLauncher;
import org.core.entity.living.human.player.LivePlayer;
import org.core.source.command.CommandSource;
import org.core.source.viewer.CommandViewer;

import java.util.*;
import java.util.stream.Collectors;

public abstract class ArgumentCommandLauncher implements BaseCommandLauncher {

    public Set<ChildArgumentCommandLauncher> commands = new HashSet<>();

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
        if(opcmd.isPresent()){
            return false;
        }
        String[] args1 = new String[args.length - 1];
        for(int A =  1; A < args.length; A++){
            args1[A-1] = args[A];
        }
        return opcmd.get().run(source, args1);
    }

    @Override
    public List<String> tab(CommandSource source, String... args) {
        if(args.length == 0){
            this.commands.stream().filter(c -> {
                if(!(c instanceof LivePlayer)){
                    return true;
                }
                Optional<String> opPermission = c.getPermission();
                if(!opPermission.isPresent()){
                    return false;
                }
                return ((LivePlayer)c).hasPermission(opPermission.get());
            }).collect(Collectors.toList());
        }
        Optional<ChildArgumentCommandLauncher> opcmd = this.commands.stream().filter(a -> args[0].equalsIgnoreCase(a.getName())).findAny();
        if(opcmd.isPresent()){
            return new ArrayList<>();
        }
        String[] args1 = new String[args.length - 1];
        for(int A =  1; A < args.length; A++){
            args1[A-1] = args[A];
        }
        return opcmd.get().tab(source, args1);
    }
}
