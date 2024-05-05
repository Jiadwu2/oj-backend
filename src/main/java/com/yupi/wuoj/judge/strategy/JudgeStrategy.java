package com.yupi.wuoj.judge.strategy;

import com.yupi.wuoj.judge.codesandbox.model.JudgeInfo;

public interface JudgeStrategy {
    JudgeInfo doJudge(JudgeContext judgeContext);
}
