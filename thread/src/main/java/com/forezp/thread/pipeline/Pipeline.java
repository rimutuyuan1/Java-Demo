package com.forezp.thread.pipeline;

/**
 * @Author 王鑫涛
 * @Description pipeline
 * @Date 2020/12/19 下午3:48
 **/
public interface Pipeline<T> {

    /**
     * 处理当前流程
     */
    void process(PipelineContext ctx, T t);

    /**
     * 转发给下游
     */
    void forward(PipelineContext ctx, T t);
}
