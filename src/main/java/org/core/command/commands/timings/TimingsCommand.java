package org.core.command.commands.timings;

import org.core.TranslateCore;
import org.core.adventureText.AText;
import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.CommandArgument;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;
import org.core.permission.CorePermission;
import org.core.permission.Permission;
import org.core.schedule.Scheduler;
import org.core.source.command.CommandSource;
import org.core.source.viewer.CommandViewer;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TimingsCommand implements ArgumentCommand {
    @Override
    public List<CommandArgument<?>> getArguments() {
        return Collections.emptyList();
    }

    @Override
    public String getDescription() {
        return "Show the timings of the current threads";
    }

    @Override
    public Optional<Permission> getPermissionNode() {
        return Optional.of(new CorePermission(false, "translatecore", "command", "timings"));
    }

    @Override
    public boolean run(CommandContext commandContext, String... args) throws NotEnoughArguments {
        if (!(commandContext.getSource() instanceof CommandViewer viewer)) {
            return false;
        }
        viewer.sendMessage(AText.ofPlain("Getting timings"));

        new Thread(() -> {
            Collection<Scheduler> schedules = TranslateCore.getScheduleManager().getSchedules();
            ThreadMXBean mxThread = ManagementFactory.getThreadMXBean();
            for (Scheduler scheduler : schedules) {
                if (!(scheduler instanceof Scheduler.Threaded threaded)) {
                    continue;
                }
                threaded.getRunning().ifPresent(thread -> {
                    long cpuTime = mxThread.getThreadCpuTime(thread.getId());

                    Duration duration = Duration.ofNanos(cpuTime);

                    viewer.sendMessage(AText.ofPlain("|---|" + scheduler.getDisplayName() + "|---|"));
                    viewer.sendMessage(AText.ofPlain(" - Plugin: " + scheduler.getPlugin().getPluginId()));
                    viewer.sendMessage(AText.ofPlain(" - Thread time (Milli-seconds): " + duration.toMillis()));
                    viewer.sendMessage(AText.ofPlain(" - Thread time (Seconds): " + duration.toSeconds()));
                });
            }
        }).start();
        return true;
    }
}
