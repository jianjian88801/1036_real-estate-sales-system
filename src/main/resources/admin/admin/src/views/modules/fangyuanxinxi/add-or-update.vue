<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
                        <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房源名称" prop="fangyuanmingcheng">
          <el-input v-model="ruleForm.fangyuanmingcheng" 
              placeholder="房源名称" clearable  :readonly="ro.fangyuanmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房源名称" prop="fangyuanmingcheng">
              <el-input v-model="ruleForm.fangyuanmingcheng" 
                placeholder="房源名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="房源类型" prop="fangyuanleixing">
          <el-select v-model="ruleForm.fangyuanleixing" placeholder="请选择房源类型">
            <el-option
                v-for="(item,index) in fangyuanleixingOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房源类型" prop="fangyuanleixing">
	      <el-input v-model="ruleForm.fangyuanleixing"
                placeholder="房源类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="房源户型" prop="fangyuanhuxing">
          <el-select v-model="ruleForm.fangyuanhuxing" placeholder="请选择房源户型">
            <el-option
                v-for="(item,index) in fangyuanhuxingOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房源户型" prop="fangyuanhuxing">
	      <el-input v-model="ruleForm.fangyuanhuxing"
                placeholder="房源户型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.fangyuantupian" label="房源图片" prop="fangyuantupian">
          <file-upload
          tip="点击上传房源图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.fangyuantupian?ruleForm.fangyuantupian:''"
          @change="fangyuantupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fangyuantupian" label="房源图片" prop="fangyuantupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fangyuantupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="所在区域" prop="suozaiquyu">
          <el-input v-model="ruleForm.suozaiquyu" 
              placeholder="所在区域" clearable  :readonly="ro.suozaiquyu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="所在区域" prop="suozaiquyu">
              <el-input v-model="ruleForm.suozaiquyu" 
                placeholder="所在区域" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房源位置" prop="fangyuanweizhi">
          <el-input v-model="ruleForm.fangyuanweizhi" 
              placeholder="房源位置" clearable  :readonly="ro.fangyuanweizhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房源位置" prop="fangyuanweizhi">
              <el-input v-model="ruleForm.fangyuanweizhi" 
                placeholder="房源位置" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房源面积" prop="fangyuanmianji">
          <el-input v-model="ruleForm.fangyuanmianji" 
              placeholder="房源面积" clearable  :readonly="ro.fangyuanmianji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房源面积" prop="fangyuanmianji">
              <el-input v-model="ruleForm.fangyuanmianji" 
                placeholder="房源面积" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="每米价格" prop="meimijiage">
          <el-input v-model="ruleForm.meimijiage" 
              placeholder="每米价格" clearable  :readonly="ro.meimijiage"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="每米价格" prop="meimijiage">
              <el-input v-model="ruleForm.meimijiage" 
                placeholder="每米价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="总计" prop="zongji">
            <el-input v-model="zongji"
                placeholder="总计" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.zongji" label="总计" prop="zongji">
              <el-input v-model="ruleForm.zongji" 
                placeholder="总计" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                  <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="发布时间" prop="fabushijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.fabushijian" 
                type="datetime"
                placeholder="发布时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian">
              <el-input v-model="ruleForm.fabushijian" 
                placeholder="发布时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="销售账号" prop="xiaoshouzhanghao">
          <el-input v-model="ruleForm.xiaoshouzhanghao" 
              placeholder="销售账号" clearable  :readonly="ro.xiaoshouzhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="销售账号" prop="xiaoshouzhanghao">
              <el-input v-model="ruleForm.xiaoshouzhanghao" 
                placeholder="销售账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="销售姓名" prop="xiaoshouxingming">
          <el-input v-model="ruleForm.xiaoshouxingming" 
              placeholder="销售姓名" clearable  :readonly="ro.xiaoshouxingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="销售姓名" prop="xiaoshouxingming">
              <el-input v-model="ruleForm.xiaoshouxingming" 
                placeholder="销售姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="销售手机" prop="xiaoshoushouji">
          <el-input v-model="ruleForm.xiaoshoushouji" 
              placeholder="销售手机" clearable  :readonly="ro.xiaoshoushouji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="销售手机" prop="xiaoshoushouji">
              <el-input v-model="ruleForm.xiaoshoushouji" 
                placeholder="销售手机" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                                          </el-row>
                                                                                                                                                                                                                                                                                                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="房源介绍" prop="fangyuanjieshao">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.fangyuanjieshao" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.fangyuanjieshao" label="房源介绍" prop="fangyuanjieshao">
                    <span v-html="ruleForm.fangyuanjieshao"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                                                        <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"rgba(34, 32, 32, 1)","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"16px","inputFontSize":"14px","textareaBgColor":"rgba(207, 199, 199, 0.13)","btnSaveFontSize":"14px","textareaBorderRadius":"16px","uploadBgColor":"rgba(207, 199, 199, 0.13)","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"rgba(207, 199, 199, 0.13)","btnSaveBorderRadius":"16px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"rgba(238, 221, 221, 0.32)","dateIconFontSize":"14px","btnSaveBgColor":"#409EFF","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"rgba(84, 244, 185, 1)","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"16px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"rgba(23, 23, 24, 1)","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"rgba(25, 26, 27, 1)","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"16px","inputBgColor":"rgba(207, 199, 199, 0.13)","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"16px","btnSaveHeight":"44px","selectBgColor":"rgba(207, 199, 199, 0.13)","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"rgba(25, 26, 27, 1)","selectBorderWidth":"1px","dateFontColor":"rgba(255, 69, 0, 0.66)","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"16px","selectFontColor":"rgba(25, 26, 27, 1)","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"1px"},
      id: '',
      type: '',
      ro:{
	fangyuanmingcheng : false,
	fangyuanleixing : false,
	fangyuanhuxing : false,
	fangyuantupian : false,
	suozaiquyu : false,
	fangyuanweizhi : false,
	fangyuanmianji : false,
	meimijiage : false,
	zongji : false,
	fangyuanjieshao : false,
	fabushijian : false,
	xiaoshouzhanghao : false,
	xiaoshouxingming : false,
	xiaoshoushouji : false,
	clicktime : false,
	clicknum : false,
      },
            ruleForm: {
                	        fangyuanmingcheng: '',
	                        	        fangyuanleixing: '',
	                        	        fangyuanhuxing: '',
	                        	        fangyuantupian: '',
	                        	        suozaiquyu: '',
	                        	        fangyuanweizhi: '',
	                        	        fangyuanmianji: '',
	                        	        meimijiage: '',
	                        	        zongji: '',
	                        	        fangyuanjieshao: '',
	                        	        fabushijian: '',
	                        	        xiaoshouzhanghao: '',
	                        	        xiaoshouxingming: '',
	                        	        xiaoshoushouji: '',
	                        	        clicktime: '',
	                        	                      },
                                      fangyuanleixingOptions: [],
                                fangyuanhuxingOptions: [],
                                                                                                                                                                                                          rules: {
                  fangyuanmingcheng: [
                                    	                                                              ],
                  fangyuanleixing: [
                                    	                                                              ],
                  fangyuanhuxing: [
                                    	                                                              ],
                  fangyuantupian: [
                                    	                                                              ],
                  suozaiquyu: [
                                    	                                                              ],
                  fangyuanweizhi: [
                                    	                                                              ],
                  fangyuanmianji: [
                                                    { validator: validateNumber, trigger: 'blur' },
            	                                                              ],
                  meimijiage: [
                                                    { validator: validateNumber, trigger: 'blur' },
            	                                                              ],
                  zongji: [
                                                    { validator: validateNumber, trigger: 'blur' },
            	                                                              ],
                  fangyuanjieshao: [
                                    	                                                              ],
                  fabushijian: [
                                    	                                                              ],
                  xiaoshouzhanghao: [
                                    	                                                              ],
                  xiaoshouxingming: [
                                    	                                                              ],
                  xiaoshoushouji: [
                                    	                    { validator: validateMobile, trigger: 'blur' },
                                                                      ],
                  clicktime: [
                                    	                                                              ],
                  clicknum: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                        	                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                            zongji:{
                                                                                                                                                                                                                                                            get: function () {
        return 1*this.ruleForm.fangyuanmianji*this.ruleForm.meimijiage
      }
    },
                                                                                                  },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          	            if(o=='fangyuanmingcheng'){
            this.ruleForm.fangyuanmingcheng = obj[o];
	    this.ro.fangyuanmingcheng = true;
            continue;
          }
	            	            if(o=='fangyuanleixing'){
            this.ruleForm.fangyuanleixing = obj[o];
	    this.ro.fangyuanleixing = true;
            continue;
          }
	            	            if(o=='fangyuanhuxing'){
            this.ruleForm.fangyuanhuxing = obj[o];
	    this.ro.fangyuanhuxing = true;
            continue;
          }
	            	            if(o=='fangyuantupian'){
            this.ruleForm.fangyuantupian = obj[o];
	    this.ro.fangyuantupian = true;
            continue;
          }
	            	            if(o=='suozaiquyu'){
            this.ruleForm.suozaiquyu = obj[o];
	    this.ro.suozaiquyu = true;
            continue;
          }
	            	            if(o=='fangyuanweizhi'){
            this.ruleForm.fangyuanweizhi = obj[o];
	    this.ro.fangyuanweizhi = true;
            continue;
          }
	            	            if(o=='fangyuanmianji'){
            this.ruleForm.fangyuanmianji = obj[o];
	    this.ro.fangyuanmianji = true;
            continue;
          }
	            	            if(o=='meimijiage'){
            this.ruleForm.meimijiage = obj[o];
	    this.ro.meimijiage = true;
            continue;
          }
	            	            if(o=='zongji'){
            this.ruleForm.zongji = obj[o];
	    this.ro.zongji = true;
            continue;
          }
	            	            if(o=='fangyuanjieshao'){
            this.ruleForm.fangyuanjieshao = obj[o];
	    this.ro.fangyuanjieshao = true;
            continue;
          }
	            	            if(o=='fabushijian'){
            this.ruleForm.fabushijian = obj[o];
	    this.ro.fabushijian = true;
            continue;
          }
	            	            if(o=='xiaoshouzhanghao'){
            this.ruleForm.xiaoshouzhanghao = obj[o];
	    this.ro.xiaoshouzhanghao = true;
            continue;
          }
	            	            if(o=='xiaoshouxingming'){
            this.ruleForm.xiaoshouxingming = obj[o];
	    this.ro.xiaoshouxingming = true;
            continue;
          }
	            	            if(o=='xiaoshoushouji'){
            this.ruleForm.xiaoshoushouji = obj[o];
	    this.ro.xiaoshoushouji = true;
            continue;
          }
	            	            if(o=='clicktime'){
            this.ruleForm.clicktime = obj[o];
	    this.ro.clicktime = true;
            continue;
          }
	            	            if(o=='clicknum'){
            this.ruleForm.clicknum = obj[o];
	    this.ro.clicknum = true;
            continue;
          }
	                    }
                                                                                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                                                                                                                                                                        		if(json.xiaoshouzhanghao!=''&&json.xiaoshouzhanghao){
              		this.ruleForm.xiaoshouzhanghao = json.xiaoshouzhanghao
		}
                                  		if(json.xiaoshouxingming!=''&&json.xiaoshouxingming){
              		this.ruleForm.xiaoshouxingming = json.xiaoshouxingming
		}
                                  		if(json.xiaoshoushouji!=''&&json.xiaoshoushouji){
              		this.ruleForm.xiaoshoushouji = json.xiaoshoushouji
		}
                                                                          } else {
          this.$message.error(data.msg);
        }
      });
                                                            this.$http({
              url: `option/fangyuanleixing/fangyuanleixing`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.fangyuanleixingOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                        this.$http({
              url: `option/fangzihuxing/fangzihuxing`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.fangyuanhuxingOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                                                                                                                                                                                                                                                      },
                                                                                                                                        // 多级联动参数
                                                                                                                                                                            info(id) {
      this.$http({
        url: `fangyuanxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
	this.ruleForm.fangyuanjieshao = this.ruleForm.fangyuanjieshao.replace(reg,'../../../springbootbqv00/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
              this.ruleForm.zongji = this.zongji
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                                                    this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `fangyuanxinxi/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.fangyuanxinxiCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.fangyuanxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
                                                            fangyuantupianUploadChange(fileUrls) {
                this.ruleForm.fangyuantupian = fileUrls;
				this.addEditUploadStyleChange()
            },
                                                                                                                                                            	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
