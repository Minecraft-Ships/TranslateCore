package org.core.command.commands.timings;

import com.sun.management.OperatingSystemMXBean;
import org.core.TranslateCore;
import org.core.adventureText.AText;
import org.core.command.argument.ArgumentCommand;
import org.core.command.argument.CommandArgument;
import org.core.command.argument.arguments.operation.ExactArgument;
import org.core.command.argument.context.CommandContext;
import org.core.exceptions.NotEnoughArguments;
import org.core.permission.CorePermission;
import org.core.permission.Permission;
import org.core.schedule.Scheduler;
import org.core.source.command.CommandSource;

import java.lang.management.ManagementFactory;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TimingsCommand implements ArgumentCommand {
    @Override
    public List<CommandArgument<?>> getArguments() {
        return List.of(new ExactArgument("timings"));
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
        CommandSource viewer = commandContext.getSource();
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        viewer.sendMessage(AText.ofPlain("Getting timings"));
        viewer.sendMessage(AText.ofPlain("CPU usage: " + osBean.getProcessCpuLoad()));
        viewer.sendMessage(AText.ofPlain("CPU process usage: " + osBean.getProcessCpuLoad()));

        new Thread(() -> {
            Collection<Scheduler> schedules = TranslateCore.getScheduleManager().getSchedules();
            viewer.sendMessage(AText.ofPlain("Scheduled tasks: " + schedules.size()));
            for (Scheduler scheduler : schedules) {
                viewer.sendMessage(AText.ofPlain(
                        "|---|" + scheduler.getDisplayName() + " - " + scheduler.getPlugin().getPluginId() + " |---|"));
                viewer.sendMessage(AText.ofPlain(" - ASync: " + scheduler.isAsync()));

                Optional<LocalTime> startRunner = scheduler.getStartRunnerTime();
                if (startRunner.isEmpty()) {
                    viewer.sendMessage(AText.ofPlain(" - Run Time: Not started"));
                } else {
                    int duration =
                            scheduler.getEndTime().orElseGet(LocalTime::now).getNano() - (startRunner.get().getNano());
                    viewer.sendMessage(AText.ofPlain(" - Run Time: " + duration));
                }
                viewer.sendMessage(AText.ofPlain(" - Has Ended: " + scheduler.getEndTime().isPresent()));
            }
        }).start();
        return true;
    }
}
