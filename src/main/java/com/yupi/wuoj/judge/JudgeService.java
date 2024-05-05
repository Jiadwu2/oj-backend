package com.yupi.wuoj.judge;

import com.yupi.wuoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.wuoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yupi.wuoj.model.entity.QuestionSubmit;
import com.yupi.wuoj.model.vo.QuestionSubmitVO;

/**
 * 判题服务
 */
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    public QuestionSubmit doJudge(long questionSubmitId);
}
