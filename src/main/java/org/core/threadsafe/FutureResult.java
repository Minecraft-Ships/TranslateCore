package org.core.threadsafe;

import java.util.Optional;
import java.util.function.Consumer;

public class FutureResult<T> {

    private Consumer<T> run;
    private T value;

    public void onComplete(Consumer<T> consumer){
        this.run = consumer;
    }

    public Optional<T> getValue(){
        return Optional.ofNullable(this.value);
    }

    public void run(T value){
        this.value = value;
        if(this.run == null){
            return;
        }
        this.run.accept(value);
    }
}
