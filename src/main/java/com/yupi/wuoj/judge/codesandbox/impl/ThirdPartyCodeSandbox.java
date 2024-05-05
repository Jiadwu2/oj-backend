package com.yupi.wuoj.judge.codesandbox.impl;

import com.yupi.wuoj.judge.codesandbox.CodeSandbox;
import com.yupi.wuoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.wuoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 第三方代码沙箱（调用现成的沙箱）
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
