package com.yupi.wuoj.judge.codesandbox.impl;

import com.yupi.wuoj.judge.codesandbox.CodeSandbox;
import com.yupi.wuoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.wuoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yupi.wuoj.judge.codesandbox.model.JudgeInfo;
import com.yupi.wuoj.model.enums.JudgeInfoMessageEnum;
import com.yupi.wuoj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱（仅为了跑通业务流程）
 */
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());

        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setTime(100L);
        judgeInfo.setMemory(100L);

        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
