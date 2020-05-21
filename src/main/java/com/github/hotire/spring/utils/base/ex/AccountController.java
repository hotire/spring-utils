package com.github.hotire.spring.utils.base.ex;

import com.github.hotire.spring.utils.base.EntityController;
import com.github.hotire.spring.utils.base.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
@RequiredArgsConstructor
public class AccountController extends EntityController<Account> {

    private final AccountService accountService;

    @Override
    protected EntityService getService() {
        return accountService;
    }
}
