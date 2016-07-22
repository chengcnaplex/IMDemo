package com.example.chengmengzhen.imdemo.url;

import com.example.chengmengzhen.imdemo.bean.Device;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by APLEX on 2016/7/21.
 */
public interface DeviceUrl {
    /*****************************************************************
     * Retrofit 2.0 只能定义这样的模式(如下)
     * <p/>
     * // Synchronous Call in Retrofit 2.0
     * Call<Contributor> call = GitHubUrl.contributors();
     * Contributor contributor = call.execute();
     * <p/>
     * // Synchronous Call in Retrofit 2.0
     * Call<Contributor> call = GitHubUrl.contributors();
     * call.enqueue(new Callback<Contributor>() {
     *
     * @Override public void onResponse(Response<Contributor> response) {
     * Get result Repo from response.body()
     * }
     * @Override public void onFailure(Throwable t) {
     * <p/>
     * }
     * });
     ********************************************************************/
    @GET("finduser")
    Call<Device> Devices();


    /*****************************************************************
     *
     *         Retrofit 1.9 同步请求
     *       Synchronous in Retrofit 1.9
     *  @GET("repos/{owner}/{repo}/contributors")
     *  List<Contributor> contributors(@Path("owner") String owner,@Path("repo") String repo);
     *
     * *************************************************************/

    /*****************************************************************
     *
     *         Retrofit 1.9 异步请求
     *      Asynchronous in Retrofit 1.9
     *  @GET("repos/{owner}/{repo}/contributors")
     *  void contributors( @Path("owner") String owner, @Path("repo") String repo,Callback<Contributor> cb);
     *
     * *************************************************************/
}
