package jcstress;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Arbiter;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.ZZ_Result;

import java.util.BitSet;

@JCStressTest
@State
@Outcome(id = "true, true", expect = Expect.ACCEPTABLE)
public class BitSetTest {
    BitSet bitSet = new BitSet();

    @Actor
    void t1() {
        synchronized (bitSet) {
            bitSet.set(0);
        }
    }

    @Actor
    void t2() {
        synchronized (bitSet) {
            bitSet.set(1);
        }
    }

    @Arbiter
    void a(ZZ_Result r) {
        r.r1 = bitSet.get(0);
        r.r2 = bitSet.get(1);
    }
}
