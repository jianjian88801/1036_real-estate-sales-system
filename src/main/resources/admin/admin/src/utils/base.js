const base = {
    get() {
                return {
            url : "http://localhost:8080/springbootbqv00/",
            name: "springbootbqv00",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootbqv00/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "房产销售系统"
        } 
    }
}
export default base
