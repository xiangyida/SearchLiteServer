package xyh.searchlite.search.service;

import xyh.searchlite.search.entity.SearchData;

public interface SearchDataService {

    /**
     * 向kafka发送搜索数据
     * @param searchData
     */
    void collectSearchData(SearchData searchData);
}
