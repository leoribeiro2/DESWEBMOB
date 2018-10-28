/*
 * Author: Leonardo Ribeiro Guimaraes
 * RA: 816119319
 */

/*
 * Author: Leonardo Ribeiro Guimaraes
 * RA: 816119319
 */

package br.com.leoribeiorweb.pipocaccp3anbua.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmListReponse {
    private Integer page;
    @SerializedName("total_results")
    private Integer totalResults;
    @SerializedName("total_pages")
    private Integer totalPages;
    private List<Film> results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Film> getResults() {
        return results;
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }
}
