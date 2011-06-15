/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */

package com.ewcms.generator.freemarker.directive.out.article;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ewcms.common.lang.EmptyUtil;
import com.ewcms.content.document.model.Article;
import com.ewcms.content.document.model.Relation;
import com.ewcms.generator.freemarker.directive.out.HtmlDirectiveOut;

import freemarker.core.Environment;
import freemarker.template.TemplateModelException;

/**
 * 引用文章标签输出
 * 
 * @author wangwei
 */
public class RelationsDirectiveOut extends HtmlDirectiveOut {
    private static final Logger logger = LoggerFactory.getLogger(RelationsDirectiveOut.class);
   
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Object loopValue(Object value, Environment env, Map params)throws TemplateModelException {
        List<Article> articles = new ArrayList<Article>();
        if(EmptyUtil.isNotNull(value)){
            List<Relation> list = (List<Relation>)value;
            for(Relation r : list){
                articles.add(r.getArticle());
            }
        }else{
            logger.debug("Loop value is null");
        }
        return articles;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public String constructOut(Object value, Environment env, Map params)throws TemplateModelException {
        if(EmptyUtil.isNull(value)){
            logger.debug("Construct value is null");
            return null;
        }
        List<Relation> list = (List<Relation>)value;
        if(EmptyUtil.isCollectionEmpty(list)){
            logger.debug("Relateds is empty");
            return null;
        }
        
        StringBuilder builder = new StringBuilder();
        
        builder.append("<ul");
        String c = getClassValue(params);
        if(EmptyUtil.isNotNull(c)){builder.append(" class=\"").append(c).append("\"");}
        String s = getStyleValue(params);
        if(EmptyUtil.isNotNull(s)){builder.append(" style=\"").append(s).append("\"");}
        builder.append(">");
        for(Relation r : list){
            Article article = r.getArticle();
            builder.append("<li>");
            builder.append("<a href=\"").append(article.getUrl()).append("\" title=\"").append(article.getTitle()).append("\" target=\"_blank\">");
            builder.append(article.getTitle());
            builder.append("</a>");
            builder.append("</li>");
        }
        builder.append("</ul>");
        
        return builder.toString();
    }
    
    
}
