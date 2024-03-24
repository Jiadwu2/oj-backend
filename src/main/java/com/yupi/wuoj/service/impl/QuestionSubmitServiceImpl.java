package com.yupi.wuoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wuoj.common.ErrorCode;
import com.yupi.wuoj.exception.BusinessException;
import com.yupi.wuoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.wuoj.model.entity.Question;
import com.yupi.wuoj.model.entity.QuestionSubmit;
import com.yupi.wuoj.model.entity.User;
import com.yupi.wuoj.model.enums.QuestionSubmitLanguageEnum;
import com.yupi.wuoj.model.enums.QuestionSubmitStatusEnum;
import com.yupi.wuoj.service.QuestionService;
import com.yupi.wuoj.service.QuestionSubmitService;
import com.yupi.wuoj.mapper.QuestionSubmitMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wujd
 * @description 针对表【question_submit(题目提交)】的数据库操作Service实现
 * @createDate 2024-03-22 11:31:26
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
        implements QuestionSubmitService {

    @Resource
    private QuestionService questionService;

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        //校验编程语言是否合法
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if(languageEnum == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言错误");
        }

        // 判断实体是否存在，根据类别获取实体
        long questionId = questionSubmitAddRequest.getQuestionId();
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已题目提交
        long userId = loginUser.getId();
        // 每个用户串行题目提交
        // 锁必须要包裹住事务方法
        QuestionSubmitService questionSubmitService = (QuestionSubmitService) AopContext.currentProxy();
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmit.getCode());
        questionSubmit.setLanguage(language);
        //todo 设置初始状态
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据插入失败");
        }
        return questionSubmit.getId();
    }


}



