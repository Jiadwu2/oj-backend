package com.yupi.wuoj.service;

import com.yupi.wuoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.wuoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.wuoj.model.entity.User;

/**
* @author wujd
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-03-22 11:31:26
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

}
