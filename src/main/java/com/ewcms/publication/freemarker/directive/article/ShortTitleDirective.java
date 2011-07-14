/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */

package com.ewcms.publication.freemarker.directive.article;

/**
 * 文章短标题
 * 
 * @deprecated
 * @author wangwei
 */
public class ShortTitleDirective extends ArticlePropertyDirective {

    @Override
    protected String getPropertyName() {
        return "shortTitle";
    }
}
