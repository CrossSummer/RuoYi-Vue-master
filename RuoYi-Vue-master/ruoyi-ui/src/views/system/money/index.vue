<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="客人ID" prop="guestId">
        <el-input
          v-model="queryParams.guestId"
          placeholder="请输入客人ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客人所属计划" prop="guesetPlan">
        <el-input
          v-model="queryParams.guesetPlan"
          placeholder="请输入客人所属计划"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支出(客人)" prop="guestCost">
        <el-input
          v-model="queryParams.guestCost"
          placeholder="请输入支出(客人)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收入(客人)" prop="guestIncome">
        <el-input
          v-model="queryParams.guestIncome"
          placeholder="请输入收入(客人)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="利润(客人)" prop="guestProfit">
        <el-input
          v-model="queryParams.guestProfit"
          placeholder="请输入利润(客人)"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:money:add']"
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
          v-hasPermi="['system:money:edit']"
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
          v-hasPermi="['system:money:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:money:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="moneyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="moneyId" />
      <el-table-column label="客人ID" align="center" prop="guestId" />
      <el-table-column label="客人所属计划" align="center" prop="guesetPlan" />
      <el-table-column label="支出(客人)" align="center" prop="guestCost" />
      <el-table-column label="收入(客人)" align="center" prop="guestIncome" />
      <el-table-column label="利润(客人)" align="center" prop="guestProfit" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:money:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:money:remove']"
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

    <!-- 添加或修改客人收入支出对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="客人ID" prop="guestId">
          <el-input v-model="form.guestId" placeholder="请输入客人ID" />
        </el-form-item>
        <el-form-item label="客人所属计划" prop="guesetPlan">
          <el-input v-model="form.guesetPlan" placeholder="请输入客人所属计划" />
        </el-form-item>
        <el-form-item label="支出(客人)" prop="guestCost">
          <el-input v-model="form.guestCost" placeholder="请输入支出(客人)" />
        </el-form-item>
        <el-form-item label="收入(客人)" prop="guestIncome">
          <el-input v-model="form.guestIncome" placeholder="请输入收入(客人)" />
        </el-form-item>
        <el-form-item label="利润(客人)" prop="guestProfit">
          <el-input v-model="form.guestProfit" placeholder="请输入利润(客人)" />
        </el-form-item>
        <el-divider content-position="center">客人管理信息</el-divider>
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
                <el-option label="请选择字典生成" value="" />
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
          <el-table-column label="所属计划" prop="plan" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.plan" placeholder="请输入所属计划" />
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
import { listMoney, getMoney, delMoney, addMoney, updateMoney } from "@/api/system/money";

export default {
  name: "Money",
  dicts: ['sys_user_sex'],
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
      // 客人收入支出表格数据
      moneyList: [],
      // 客人管理表格数据
      yqGuestList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        guestId: null,
        guesetPlan: null,
        guestCost: null,
        guestIncome: null,
        guestProfit: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询客人收入支出列表 */
    getList() {
      this.loading = true;
      listMoney(this.queryParams).then(response => {
        this.moneyList = response.rows;
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
        moneyId: null,
        guestId: null,
        guesetPlan: null,
        guestCost: null,
        guestIncome: null,
        guestProfit: null
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
      this.ids = selection.map(item => item.moneyId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加客人收入支出";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const moneyId = row.moneyId || this.ids
      getMoney(moneyId).then(response => {
        this.form = response.data;
        this.yqGuestList = response.data.yqGuestList;
        this.open = true;
        this.title = "修改客人收入支出";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.yqGuestList = this.yqGuestList;
          if (this.form.moneyId != null) {
            updateMoney(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMoney(this.form).then(response => {
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
      const moneyIds = row.moneyId || this.ids;
      this.$modal.confirm('是否确认删除客人收入支出编号为"' + moneyIds + '"的数据项？').then(function() {
        return delMoney(moneyIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 客人管理序号 */
    rowYqGuestIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 客人管理添加按钮操作 */
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
      obj.plan = "";
      this.yqGuestList.push(obj);
    },
    /** 客人管理删除按钮操作 */
    handleDeleteYqGuest() {
      if (this.checkedYqGuest.length == 0) {
        this.$modal.msgError("请先选择要删除的客人管理数据");
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
      this.download('system/money/export', {
        ...this.queryParams
      }, `money_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
