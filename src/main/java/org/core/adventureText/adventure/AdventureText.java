package org.core.adventureText.adventure;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import net.kyori.adventure.util.RGBLike;
import org.core.adventureText.AText;
import org.core.adventureText.format.NamedTextColours;
import org.core.adventureText.format.TextColour;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Deprecated(forRemoval = true)
public class AdventureText implements AText {

    private final Component component;

    public AdventureText(Component component) {
        this.component = component;
    }

    private AdventureText toAdventure(AText aText) {
        if (aText instanceof AdventureText) {
            return (AdventureText) aText;
        }
        throw new IllegalStateException("text needs to be adventureText to interact with adventureText, found " + aText
                .getClass()
                .getSimpleName());
    }

    public @NotNull Component getComponent() {
        return this.component;
    }

    @Override
    public @NotNull AText append(@NotNull AText aText) {
        return new AdventureText(this.component.append(this.toAdventure(aText).component));
    }

    @Override
    public boolean contains(@NotNull AText aText) {
        return this.component.contains(this.toAdventure(aText).component);
    }

    @Override
    public boolean containsIgnoreCase(@NotNull String s) {
        return this.toPlain().toLowerCase().contains(s.toLowerCase());
    }

    @Override
    public @NotNull AText withAllAs(@NotNull String containing, @Nullable AText aText) {
        return new AdventureText(this.component.replaceText(TextReplacementConfig
                                                                    .builder()
                                                                    .matchLiteral(containing)
                                                                    .replacement(this.toAdventure(aText).component)
                                                                    .build()));
    }

    @Override
    public @NotNull AText withAllAsIgnoreCase(@NotNull String containing, @Nullable AText aText) {
        String asPlain = PlainComponentSerializer.plain().serialize(this.component);
        Component component = this.component;

        int containingLength = containing.length();
        int plainLength = asPlain.length();

        for (int plain = 0; plain < asPlain.length(); plain++) {
            int testingLength = (plain + containingLength);
            if (plainLength < testingLength) {
                break;
            }
            String contains = asPlain.substring(plain, plain + containingLength);
            if (!contains.equalsIgnoreCase(containing)) {
                continue;
            }
            Component replacement = Component.empty();
            if (aText != null) {
                replacement = this.toAdventure(aText).component;
            }

            component = component.replaceText(
                    TextReplacementConfig.builder().matchLiteral(contains).replacement(replacement).build());
        }
        return new AdventureText(component);
    }

    @Override
    public Optional<TextColour> getColour() {
        TextColor colour = this.component.color();
        if (colour == null) {
            return Optional.empty();
        }
        if (colour instanceof NamedTextColor) {
            Optional<TextColour> opText = NamedTextColours
                    .colours()
                    .parallelStream()
                    .filter(tc -> tc.getBlue() == ((RGBLike) colour).blue())
                    .filter(tc -> tc.getGreen() == ((RGBLike) colour).green())
                    .filter(tc -> tc.getRed() == ((RGBLike) colour).red())
                    .findAny();
            if (opText.isPresent()) {
                return opText;
            }
        }
        return Optional.of(new TextColour(colour.red(), colour.green(), colour.blue()));
    }

    @Override
    public @NotNull AText withColour(@Nullable TextColour colour) {
        if (colour == null) {
            return new AdventureText(this.component.color(null));
        }
        return new AdventureText(
                this.component.color(TextColor.color(colour.getRed(), colour.getGreen(), colour.getBlue())));
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

    public static AdventureText plain(@NotNull String text) {
        return new AdventureText(PlainComponentSerializer.plain().deserialize(text));
    }

    public static AdventureText legacy(@NotNull String text) {
        return new AdventureText(LegacyComponentSerializer.legacySection().deserialize(text));
    }
}
