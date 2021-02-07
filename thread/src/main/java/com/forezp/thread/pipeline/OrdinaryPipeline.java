package com.forezp.thread.pipeline;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/12/19 下午3:53
 **/
public abstract class OrdinaryPipeline<T> implements Pipeline<T> {

    private final String name;
    private Pipeline<? super T> next;

    public OrdinaryPipeline(String name) {
        this.name = name;
    }

    public void setNext(Pipeline<? super T> next) {
        this.next = next;
    }

    @Override
    public abstract void process(PipelineContext ctx, T t);

    @Override
    public String toString() {
        if (next != null) {
            return name + "->" + next.toString();
        }
        return name;
    }

    public static <T> Pipeline<T> getInstance(
            List<? extends OrdinaryPipeline<? extends T>> pipelines) {
        if (pipelines == null || pipelines.isEmpty()) {
            throw new IllegalArgumentException("empty pipelines!");
        }
        @SuppressWarnings("unchecked")
        OrdinaryPipeline<T>[] a = (OrdinaryPipeline<T>[]) pipelines.toArray(new OrdinaryPipeline[0]);
        OrdinaryPipeline<T> p = a[0];
        for (int i = 1; i < a.length; ++i) {
            p.setNext(a[i]);
            p = a[i];
        }
        p.setNext(null);
        return a[0];
    }

    public static class OrdinaryPipelineTest {

        public static void main(String[] args) {
            Pipeline<?> pipeline =
                    OrdinaryPipeline.getInstance(
                            Arrays.asList(new DemoPipeline("1"), new DemoPipeline("3"), new DemoPipeline("2")));
            System.out.println(pipeline.toString());
        }

        private static final class DemoPipeline extends OrdinaryPipeline<String> {

            public DemoPipeline(String name) {
                super(name);
            }

            @Override
            public void process(PipelineContext ctx, String s) {

            }

            @Override
            public void forward(PipelineContext ctx, String s) {

            }
        }
    }
}
