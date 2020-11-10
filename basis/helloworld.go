golang {

// 当前构建的包路径
packagePath = 'github.com/user/project'

// 指明当前的模式。有两个可选值：DEVELOP/REPRODUCIBLE，默认为REPRODUCIBLE
// 该配置会被命令行参数-Dgogradle.mode所覆盖
// 可缩写为DEV/REP
buildMode = 'REPRODUCIBLE'

// 构建所需的Go版本。详见 https://golang.org/dl/
// 若此值未设定，则先去本地查找go命令，找到则使用之；否则自动下载最新的Go版本
// 若此值已经设定，则检查本地的go版本是否相符，相符则使用之；否则自动下载该版本的Go
goVersion = '1.8.1'

// 默认为"go"。若go不在$PATH中，可以使用此配置指定其位置
// 可以用 goExecutable = 'IGNORE_LOCAL' 来强制指定不使用本地的go
goExecutable = '/path/to/go/executable'

// 方便自定义仓库，Gogradle会尝试从以下地址下载Go的发行版
// http://golangtc.com/static/go/${version}/go${version}.${os}-${arch}${extension}
goBinaryDownloadTemplate == 'http://golangtc.com/static/go/${version}/go${version}.${os}-${arch}${extension}'

// 默认为<go程序所在目录>/..
goRoot = '/path/to/my/goroot'

// 即build constraint。详见 https://golang.org/pkg/go/build/#hdr-Build_Constraints
buildTags = ['appengine','anothertag']

// 由于Go语言的官方下载地址在墙外，
// 开启此设置时，会使用墙内地址下载Go语言安装包
// 默认为false
fuckGfw = true
}