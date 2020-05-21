package com.github.hotire.spring.utils.base.ex;

import com.github.hotire.spring.utils.base.EntityController;
import com.github.hotire.spring.utils.base.EntityRestController;
import com.github.hotire.spring.utils.base.EntityService;

@EntityRestController(path = "/sample")
public class SampleController extends EntityController<Account> {

    @Override
    protected EntityService getService() {
        return new AccountService();
    }
}
