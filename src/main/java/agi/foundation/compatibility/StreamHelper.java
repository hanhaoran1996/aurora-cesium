package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

/**
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class StreamHelper {
    private StreamHelper() {}

    public static int read(@Nonnull InputStream stream, @Nonnull byte[] b, int off, int len) {
        ArgumentNullException.assertNonNull(stream, "stream");
        ArgumentNullException.assertNonNull(b, "b");

        try {
            return stream.read(b, off, len);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void copyTo(@Nonnull InputStream stream, @Nonnull MemoryStream destination, int bufferSize) {
        ArgumentNullException.assertNonNull(stream, "stream");
        ArgumentNullException.assertNonNull(destination, "destination");
        if (bufferSize <= 0)
            throw new ArgumentOutOfRangeException("bufferSize");

        byte[] buffer = new byte[bufferSize];
        int count;
        try {
            while ((count = stream.read(buffer, 0, buffer.length)) > 0) {
                destination.write(buffer, 0, count);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
