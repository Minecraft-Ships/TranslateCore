package org.core.adventureText.adventure;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import org.core.adventureText.AText;
import org.core.adventureText.format.NamedTextColours;
import org.core.adventureText.format.TextColour;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdventureText implements AText {

    private final Component component;

    public AdventureText(Component component) {
        this.component = component;
    }

    private AdventureText toAdventure(AText aText) {
        if (aText instanceof AdventureText) {
            return (AdventureText) aText;
        }
        throw new IllegalStateException("text needs to be adventureText to interact with adventureText");
    }

    public @NotNull Component getComponent() {
        return this.component;
    }

    @Override
    public @NotNull AText append(@NotNull AText aText) {
        return new AdventureText(this.component.append(toAdventure(aText).component));
    }

    @Override
    public boolean contains(@NotNull AText aText) {
        return this.component.contains(toAdventure(aText).component);
    }

    @Override
    public @NotNull AText withAllAs(@NotNull String containing, AText aText) {
        return new AdventureText(this.component.replaceText(
                TextReplacementConfig
                        .builder()
                        .matchLiteral(containing)
                        .replacement(toAdventure(aText).component)
                        .build()));
    }

    @Override
    public Optional<TextColour> getColour() {
        TextColor colour = this.component.color();
        if (colour == null) {
            return Optional.empty();
        }
        TextColour textColour = null;
        if (colour instanceof NamedTextColor) {
            NamedTextColor namedTextColor = ((NamedTextColor) colour);
            Optional<TextColour> opText = NamedTextColours
                    .colours()
                    .parallelStream()
                    .filter(tc -> tc.getBlue() == namedTextColor.blue())
                    .filter(tc -> tc.getGreen() == namedTextColor.green())
                    .filter(tc -> tc.getRed() == namedTextColor.red())
                    .findAny();
            if (opText.isPresent()) {
                return opText;
            }
        }
        return Optional.of(new TextColour(null, null, colour.red(), colour.green(), colour.blue()));
    }

    @Override
    public @NotNull AText withColour(TextColour colour) {
        return new AdventureText(this.component.color(TextColor.color(colour.getRed(), colour.getGreen(), colour.getBlue())));
    }

    @Override
    public @NotNull List<AText> getChildren() {
        return this.component.children().stream().map(AdventureText::new).collect(Collectors.toList());
    }

    @Override
    public @NotNull String toPlain() {
        return PlainComponentSerializer.plain().serialize(this.component);
    }

    @Override
    public @NotNull String toLegacy() {
        return LegacyComponentSerializer.legacySection().serialize(this.component);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AText)) {
            return false;
        }
        return this.toPlain().equals(((AText) obj).toPlain());
    }

    public static AdventureText plain(String text) {
        return new AdventureText(PlainComponentSerializer.plain().deserialize(text));
    }

    public static AdventureText legacy(String text) {
        return new AdventureText(LegacyComponentSerializer.legacySection().deserialize(text));
    }
}
