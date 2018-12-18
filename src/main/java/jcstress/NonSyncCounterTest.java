package jcstress;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Arbiter;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.J_Result;
import practice.samples.Counter;
import practice.samples.NonSyncCounter;

@JCStressTest
@Outcome(id = "1", expect = Expect.ACCEPTABLE)
@Outcome(id = "2", expect = Expect.ACCEPTABLE)
@State
public class NonSyncCounterTest {

    Counter counter = new NonSyncCounter();

    @Actor
    void actor1() {
        counter.increment();
    }

    @Actor
    void actor2() {
        counter.increment();
    }

    @Arbiter
    void arbiter(J_Result res) {
        res.r1 = counter.get();
    }
}
