package com.chanchal.futurestradeservice.processor;

public interface IMessageProcessor<K, V> {
    K processMessage(V request);
}
