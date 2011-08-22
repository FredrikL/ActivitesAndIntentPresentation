package com.tretton37.example.publisher;

import com.google.inject.AbstractModule;

/**
 * User: Fredrik / 2011-08-22
 */
public class PublisherModule extends AbstractModule {
    @Override
    protected void configure() {
        // bind(TransactionLog.class).to(DatabaseTransactionLog.class);
    }
}
