package com.yupi.wuoj.judge.codesandbox;

import com.yupi.wuoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.wuoj.judge.codesandbox.model.ExecuteCodeResponse;

public interface CodeSandbox {
    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
