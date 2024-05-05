package com.yupi.wuoj.judge.codesandbox;

import com.yupi.wuoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.yupi.wuoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.yupi.wuoj.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱工厂（根据字符串参数创建指定代码沙箱实例）
 */
public class CodeSandboxFactory {
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
