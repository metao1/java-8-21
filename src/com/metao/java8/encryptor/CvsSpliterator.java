package com.metao.java8.encryptor;

import java.util.function.Consumer;

public class CvsSpliterator extends DocEncryptor.FixedBatchSpliteratorBase<byte[]> {

    private final CVSReader cr;

    CvsSpliterator(CVSReader cr, int batchSize) {
        super(IMMUTABLE | ORDERED | NONNULL, batchSize);
        if (cr == null) throw new NullPointerException("Cr is null");
        this.cr = cr;
    }

    public CvsSpliterator(CVSReader cr) {
        this(cr, 128);
    }

    @Override
    public boolean tryAdvance(Consumer<? super byte[]> action) {
        if (action == null) throw new NullPointerException();
        try {
            final byte[] row = cr.readNext();
            if (row == null) return false;
            action.accept(row);
            return true;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void forEachRemaining(Consumer<? super byte[]> action) {
        if (action == null) throw new NullPointerException();
        try {
            for (byte[] row; (row = cr.readNext()) != null; ) action.accept(row);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
