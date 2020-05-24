package com.github.hotire.spring.utils.base.ex;

import com.github.hotire.spring.utils.base.EntityController;
import com.github.hotire.spring.utils.base.EntityRestController;
import com.github.hotire.spring.utils.base.EntityService;
import lombok.RequiredArgsConstructor;

@EntityRestController(path = "/sample")
@RequiredArgsConstructor
public class SampleController extends EntityController<Account> {
    private final AccountService accountService;

    @Override
    protected EntityService getService() {
        return accountService;
    }
}
