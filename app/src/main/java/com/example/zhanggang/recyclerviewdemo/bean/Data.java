package com.example.zhanggang.recyclerviewdemo.bean;

import java.util.List;

/**
 * 类作用：bean类
 * 时  间：2017/8/10 - 19:37.
 * 创建人：张刚
 */

public class Data {


    public int code;
    public String msg;
    public DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Data(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        public int stateCode;
        public String message;
        public ReturnDataBean returnData;

        public ReturnDataBean getReturnData() {
            return returnData;
        }

        public void setReturnData(ReturnDataBean returnData) {
            this.returnData = returnData;
        }

        public DataBean(ReturnDataBean returnData) {
            this.returnData = returnData;
        }

        public static class ReturnDataBean {

            public boolean hasMore;
            public DefaultParametersBean defaultParameters;
            public int page;
            public List<ComicsBean> comics;
            public List<SpinnerListBean> spinnerList;

            public List<ComicsBean> getComics() {
                return comics;
            }

            public void setComics(List<ComicsBean> comics) {
                this.comics = comics;
            }

            public ReturnDataBean(List<ComicsBean> comics) {
                this.comics = comics;
            }

            public static class DefaultParametersBean {

                public int defaultSelection;
                public int defaultArgCon;
                public String defaultConTagType;
            }

            public static class ComicsBean {

                public int newestChapter;
                public String conTag;
                public String cover;
                public String name;
                public int comicId;
                public String description;
                public int flag;
                public String author;
                public List<String> tags;

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                @Override
                public String toString() {
                    return "ComicsBean{" +
                            "newestChapter=" + newestChapter +
                            ", conTag='" + conTag + '\'' +
                            ", cover='" + cover + '\'' +
                            ", name='" + name + '\'' +
                            ", comicId=" + comicId +
                            ", description='" + description + '\'' +
                            ", flag=" + flag +
                            ", author='" + author + '\'' +
                            ", tags=" + tags +
                            '}';
                }
            }

            public static class SpinnerListBean {
                public int argCon;
                public String name;
                public String conTag;
            }
        }
    }
}
