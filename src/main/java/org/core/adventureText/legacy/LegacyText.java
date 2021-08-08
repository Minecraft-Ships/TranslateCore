package org.core.adventureText.legacy;

import org.core.adventureText.AText;
import org.core.adventureText.format.NamedTextColours;
import org.core.adventureText.format.TextColour;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LegacyText implements AText {

    private final @Nullable String text;
    private final @Nullable TextColour colour;
    private final @NotNull List<LegacyText> children = new ArrayList<>();

    public LegacyText(@Nullable TextColour colour, @Nullable String text, @NotNull Collection<LegacyText> children) {
        this.text = text;
        this.colour = colour;
        this.children.addAll(children);
    }

    private LegacyText toLegacy(AText text) {
        if (text instanceof LegacyText) {
            return (LegacyText) text;
        }
        return new LegacyText(null, text.toLegacy(), Collections.emptyList());
    }

    @Override
    public @NotNull LegacyText append(@NotNull AText aText) {
        this.children.add(toLegacy(aText));
        return this;
    }

    @Override
    public boolean contains(@NotNull AText aText) {
        if (this.text != null) {
            LegacyText legacy = toLegacy(aText);
            if (legacy.text != null && this.text.contains(legacy.text)) {
                return true;
            }
        }
        return this.children.stream().anyMatch(t -> t.contains(t));
    }

    @Override
    public @NotNull LegacyText withAllAs(@NotNull String containing, @Nullable AText aText) {
        String text = null;
        if (aText == null) {
            aText = AText.ofPlain("");
        }
        if (this.text != null) {
            //SOMETHING ISNT RIGHT HERE
            String legacyText = aText.toLegacy();
            text = this.text.replaceAll(containing, legacyText);
        }
        final AText finalText = aText;
        List<LegacyText> children = this.children.stream().map(lt -> lt.withAllAs(containing, finalText)).collect(Collectors.toList());
        return new LegacyText(this.colour, text, children);
    }

    @Override
    public Optional<TextColour> getColour() {
        return Optional.ofNullable(this.colour);
    }

    @Override
    public @NotNull LegacyText withColour(@Nullable TextColour colour) {
        return new LegacyText(colour, this.text, this.children);
    }

    @Override
    public @NotNull List<AText> getChildren() {
        return this.children.stream().map(this::toLegacy).collect(Collectors.toList());
    }

    @Override
    public @NotNull String toPlain() {
        if (this.text != null) {
            String text = this.text;

            for (TextColour colour : NamedTextColours.colours()) {
                if (!colour.getLegacy().isPresent()) {
                    continue;
                }
                text = text.replaceAll(TextColour.SYMBOL + "" + colour.getLegacy().get(), "");
            }
            return text + this.children.stream().map(LegacyText::toPlain).collect(Collectors.joining(""));

        }
        return this.children.stream().map(LegacyText::toPlain).collect(Collectors.joining(""));
    }

    @Override
    public @NotNull String toLegacy() {
        StringBuilder builder = new StringBuilder();
        if (this.colour != null) {
            builder.append(this.colour.getLegacy().map(c -> TextColour.SYMBOL + "" + c).orElse(""));
        }
        if (this.text != null) {
            builder.append(this.text);
        }
        String children = this.children.stream().map(LegacyText::toLegacy).collect(Collectors.joining(""));
        builder.append(children);
        return builder.toString();
    }

    public LegacyText plain(@NotNull String text) {
        StringBuilder builder = new StringBuilder();
        int previous = 0;
        for (int A = 0; A < text.length(); A++) {
            char at = text.charAt(A);
            if (at != TextColour.SYMBOL) {
                continue;
            }
            builder.append(text.substring(previous, A - 1));
            A++;
            previous = A;
        }
        return new LegacyText(null, builder.toString(), Collections.emptyList());
    }

    public LegacyText legacy(@NotNull String text) {
        String[] split = text.split("" + TextColour.SYMBOL);
        if (split.length == 0 || split.length == 1) {
            return new LegacyText(null, text, Collections.emptyList());
        }
        List<LegacyText> collection = Stream.of(split).filter(v -> v.length() != 0).map(v -> {
                    char at = v.charAt(0);
                    Optional<TextColour> opLegacy = NamedTextColours
                            .colours()
                            .parallelStream()
                            .filter(tc -> tc.getLegacy().map(c -> c == at).orElse(false))
                            .findAny();
                    return opLegacy
                            .map(textColour -> new LegacyText(textColour, v.substring(1), Collections.emptyList()))
                            .orElseGet(() -> new LegacyText(null, v, Collections.emptyList()));
                })
                .collect(Collectors.toList());

        return new LegacyText(null, null, collection);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AText)) {
            return false;
        }
        String plain = ((AText) obj).toPlain();
        String thisPlain = this.toPlain();

        return thisPlain.equals(plain);
    }
}
