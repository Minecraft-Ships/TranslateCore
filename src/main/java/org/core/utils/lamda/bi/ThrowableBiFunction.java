package org.core.utils.lamda.bi;

public interface ThrowableBiFunction<OriginalParam1, OriginalParam2, Mapped, Throw extends Throwable> {

    Mapped map(OriginalParam1 param1, OriginalParam2 param2) throws Throw;

}
