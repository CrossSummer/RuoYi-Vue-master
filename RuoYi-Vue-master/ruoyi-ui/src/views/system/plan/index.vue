<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="计划名称" prop="planName">
        <el-input
          v-model="queryParams.planName"
          placeholder="请输入计划名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收件日期" prop="receiptDate">
        <el-date-picker clearable
          v-model="queryParams.receiptDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择收件日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="录指纹日期时间" prop="fingerprintDatetime">
        <el-date-picker clearable
          v-model="queryParams.fingerprintDatetime"
          type="datetime"
          value-format="yyyy-MM-dd HH:mm:ss"
          placeholder="请选择录指纹日期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="出行日期" prop="travelDate">
        <el-date-picker clearable
          v-model="queryParams.travelDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出行日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="签证国" prop="visaCountry">
        <el-input
          v-model="queryParams.visaCountry"
          placeholder="请输入签证国"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="送签日期" prop="submitDate">
        <el-date-picker clearable
          v-model="queryParams.submitDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择送签日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="送签城市" prop="submitCity">
        <el-input
          v-model="queryParams.submitCity"
          placeholder="请输入送签城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售" prop="salePerson">
        <el-input
          v-model="queryParams.salePerson"
          placeholder="请输入销售"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户" prop="custom">
        <el-input
          v-model="queryParams.custom"
          placeholder="请输入客户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客人名(...等)" prop="guestEq">
        <el-input
          v-model="queryParams.guestEq"
          placeholder="请输入客人名(...等)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客人数" prop="guestNum">
        <el-input
          v-model="queryParams.guestNum"
          placeholder="请输入客人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="账号" prop="account">
        <el-input
          v-model="queryParams.account"
          placeholder="请输入账号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="计划类型" prop="plantype">
        <el-select v-model="queryParams.plantype" placeholder="请选择类型">
          <el-option
            v-for="dict in dict.type.yq_plan_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:plan:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:plan:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:plan:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:plan:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="planList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="计划ID" align="center" prop="planId" />
      <el-table-column label="计划名称" align="center" prop="planName" />
      <el-table-column label="收件日期" align="center" prop="receiptDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.receiptDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="录指纹日期时间" align="center" prop="fingerprintDatetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.fingerprintDatetime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="出行日期" align="center" prop="travelDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.travelDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="签证国" align="center" prop="visaCountry" />
      <el-table-column label="送签日期" align="center" prop="submitDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.submitDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="送签城市" align="center" prop="submitCity" />
      <el-table-column label="销售" align="center" prop="salePerson" />
      <el-table-column label="客户" align="center" prop="custom" />
      <el-table-column label="客人名(...等)" align="center" prop="guestEq" />
      <el-table-column label="客人数" align="center" prop="guestNum" />
      <el-table-column label="账号" align="center" prop="account" />
      <el-table-column label="备注" align="center" prop="notes" />
      <el-table-column label="计划类型" align="center" prop="plantype">
      <template slot-scope="scope"><!--翻译字典数据-->
        <dict-tag :options="dict.type.yq_plan_type" :value="scope.row.plantype"/>
      </template>
      </el-table-column>

      <el-table-column label="支出(计划)" align="center" prop="planCost" />
      <el-table-column label="收入(计划)" align="center" prop="planIncome" />
      <el-table-column label="利润(计划)" align="center" prop="planProfit" />

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:plan:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:plan:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改送签计划对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" :inline="true">
        <el-form-item label="计划名称" prop="planName">
          <el-input v-model="form.planName" placeholder="请输入计划名称" />
        </el-form-item>
        <el-form-item label="收件日期" prop="receiptDate">
          <el-date-picker clearable
            v-model="form.receiptDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择收件日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="录指纹日期时间" prop="fingerprintDatetime">
          <el-date-picker clearable
            v-model="form.fingerprintDatetime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择录指纹日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出行日期" prop="travelDate">
          <el-date-picker clearable
            v-model="form.travelDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出行日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="签证国" prop="visaCountry">
          <el-input v-model="form.visaCountry" placeholder="请输入签证国" />
        </el-form-item>
        <el-form-item label="送签日期" prop="submitDate">
          <el-date-picker clearable
            v-model="form.submitDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择送签日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="送签城市" prop="submitCity">
          <el-input v-model="form.submitCity" placeholder="请输入送签城市" />
        </el-form-item>
        <el-form-item label="销售" prop="salePerson">
          <el-input v-model="form.salePerson" placeholder="请输入销售" />
        </el-form-item>
        <el-form-item label="客户" prop="custom">
          <el-input v-model="form.custom" placeholder="请输入客户" />
        </el-form-item>
        <el-form-item label="客人名(...等)" prop="guestEq">
          <el-input v-model="form.guestEq" placeholder="请输入客人名(...等)" />
        </el-form-item>
        <el-form-item label="客人数" prop="guestNum">
          <el-input v-model="form.guestNum" placeholder="请输入客人数" />
        </el-form-item>
        <el-form-item label="账号" prop="account">
          <el-input v-model="form.account" placeholder="请输入账号" />
        </el-form-item>
        <el-form-item label="备注" prop="notes">
          <el-input v-model="form.notes" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="计划类型" prop="plantype" >
          <el-select v-model="form.plantype" placeholder="请选择类型">
            <el-option
              v-for="dict in dict.type.yq_plan_type"
              :key="dict.value"
              :label="dict.label"
              :value="Number(dict.value)"
            ></el-option>
          </el-select>
          <!--搜索选项-下拉框（使用字典）,Number转换-->
        </el-form-item>

        <el-form-item label="支出(计划)" prop="planCost">
          <el-input v-model="form.planCost" placeholder="请输入支出(计划)" />
        </el-form-item>
        <el-form-item label="收入(计划)" prop="planIncome">
          <el-input v-model="form.planIncome" placeholder="请输入收入(计划)" />
        </el-form-item>
        <el-form-item label="利润(计划)" prop="planProfit">
          <el-input v-model="form.planProfit" placeholder="请输入利润(计划)" />
        </el-form-item>

        <el-divider content-position="center">客人信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddYqGuest">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteYqGuest">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="yqGuestList" :row-class-name="rowYqGuestIndex" @selection-change="handleYqGuestSelectionChange" ref="yqGuest">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="中文姓名" prop="ppChinesename" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ppChinesename" placeholder="请输入中文姓名" />
            </template>
          </el-table-column>
          <el-table-column label="姓(英文)" prop="ppFamilyname" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ppFamilyname" placeholder="请输入姓(英文)" />
            </template>
          </el-table-column>
          <el-table-column label="名(英文)" prop="ppFirstname" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ppFirstname" placeholder="请输入名(英文)" />
            </template>
          </el-table-column>
          <el-table-column label="性别" prop="ppGender" width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.ppGender" placeholder="请选择性别">
                <el-option
                  v-for="dict in dict.type.sys_user_sex"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="出生日期" prop="ppBirthDate" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.ppBirthDate" type="date" value-format="yyyy-MM-dd" placeholder="请选择出生日期" />
            </template>
          </el-table-column>
          <el-table-column label="出生地点" prop="ppBirthPlace" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ppBirthPlace" placeholder="请输入出生地点" />
            </template>
          </el-table-column>
          <el-table-column label="国籍" prop="ppNationality" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ppNationality" placeholder="请输入国籍" />
            </template>
          </el-table-column>
          <el-table-column label="手机" prop="guestPhone" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.guestPhone" placeholder="请输入手机" />
            </template>
          </el-table-column>
          <el-table-column label="邮箱" prop="guestEmail" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.guestEmail" placeholder="请输入邮箱" />
            </template>
          </el-table-column>
          <el-table-column label="护照国家码" prop="ppCountryCode" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ppCountryCode" placeholder="请输入护照国家码" />
            </template>
          </el-table-column>
          <el-table-column label="护照号码" prop="ppNo" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ppNo" placeholder="请输入护照号码" />
            </template>
          </el-table-column>
          <el-table-column label="护照类型" prop="ppType" width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.ppType" placeholder="请选择护照类型">
                <el-option
                  v-for="dict in dict.type.yq_passport_type"
                  :key="dict.value"
                  :label="dict.label"
                  :value="dict.value"
                ></el-option>
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="护照签发日期" prop="ppIssueDate" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.ppIssueDate" type="date" value-format="yyyy-MM-dd" placeholder="请选择护照签发日期" />
            </template>
          </el-table-column>
          <el-table-column label="护照签发地点" prop="ppIssuePlace" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ppIssuePlace" placeholder="请输入护照签发地点" />
            </template>
          </el-table-column>
          <el-table-column label="护照有效期至" prop="ppExpireDate" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.ppExpireDate" type="date" value-format="yyyy-MM-dd" placeholder="请选择护照有效期至" />
            </template>
          </el-table-column>
          <el-table-column label="护照签发机关" prop="ppIssueOrganization" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ppIssueOrganization" placeholder="请输入护照签发机关" />
            </template>
          </el-table-column>

          <el-table-column label="支出(客人)" prop="guestCost" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.guestCost" placeholder="请输入支出(客人)" />
            </template>
          </el-table-column>
          <el-table-column label="收入(客人)" prop="guestIncome" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.guestIncome" placeholder="请输入收入(客人)" />
            </template>
          </el-table-column>
          <el-table-column label="利润(客人)" prop="guestProfit" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.guestProfit" placeholder="请输入利润(客人)" />
            </template>
          </el-table-column>

        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPlan, getPlan, delPlan, addPlan, updatePlan } from "@/api/system/plan";

export default {
  name: "Plan",
  dicts: ['sys_normal_disable', 'sys_user_sex', 'yq_passport_type', 'yq_plan_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedYqGuest: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 送签计划表格数据
      planList: [],
      // ${subTable.functionName}表格数据
      yqGuestList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        planName: null,
        receiptDate: null,
        fingerprintDatetime: null,
        travelDate: null,
        visaCountry: null,
        submitDate: null,
        submitCity: null,
        salePerson: null,
        custom: null,
        guestEq: null,
        guestNum: null,
        account: null,
        notes: null,
        plantype: null,
        planCost: null,
        planIncome: null,
        planProfit: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        planName: [
          { required: true, message: "计划名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询送签计划列表 */
    getList() {
      this.loading = true;
      listPlan(this.queryParams).then(response => {
        this.planList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        planId: null,
        planName: null,
        receiptDate: null,
        fingerprintDatetime: null,
        travelDate: null,
        visaCountry: null,
        submitDate: null,
        submitCity: null,
        salePerson: null,
        custom: null,
        guestEq: null,
        guestNum: null,
        account: null,
        notes: null,
        plantype: null,
        planCost: null,
        planIncome: null,
        planProfit: null
      };
      this.yqGuestList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.planId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加送签计划";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const planId = row.planId || this.ids
      getPlan(planId).then(response => {
        this.form = response.data;
        this.yqGuestList = response.data.yqGuestList;
        this.open = true;
        this.title = "修改送签计划";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.yqGuestList = this.yqGuestList;
          if (this.form.planId != null) {
            updatePlan(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPlan(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const planIds = row.planId || this.ids;
      this.$modal.confirm('是否确认删除送签计划编号为"' + planIds + '"的数据项？').then(function() {
        return delPlan(planIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 客人序号 */
    rowYqGuestIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 客人添加按钮操作 */
    handleAddYqGuest() {
      let obj = {};
      obj.ppChinesename = "";
      obj.ppFamilyname = "";
      obj.ppFirstname = "";
      obj.ppGender = "";
      obj.ppBirthDate = "";
      obj.ppBirthPlace = "";
      obj.ppNationality = "";
      obj.guestPhone = "";
      obj.guestEmail = "";
      obj.ppCountryCode = "";
      obj.ppNo = "";
      obj.ppType = "";
      obj.ppIssueDate = "";
      obj.ppIssuePlace = "";
      obj.ppExpireDate = "";
      obj.ppIssueOrganization = "";
      obj.planCost = "";
      obj.planIncome = "";
      obj.planProfit = "";
      this.yqGuestList.push(obj);
    },
    /** 客人删除按钮操作 */
    handleDeleteYqGuest() {
      if (this.checkedYqGuest.length == 0) {
        this.$modal.msgError("请先选择要删除的客人数据");
      } else {
        const yqGuestList = this.yqGuestList;
        const checkedYqGuest = this.checkedYqGuest;
        this.yqGuestList = yqGuestList.filter(function(item) {
          return checkedYqGuest.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleYqGuestSelectionChange(selection) {
      this.checkedYqGuest = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/plan/export', {
        ...this.queryParams
      }, `plan_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
