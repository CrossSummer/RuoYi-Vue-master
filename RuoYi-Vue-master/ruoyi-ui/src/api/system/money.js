import request from '@/utils/request'

// 查询客人收入支出列表
export function listMoney(query) {
  return request({
    url: '/system/money/list',
    method: 'get',
    params: query
  })
}

// 查询客人收入支出详细
export function getMoney(moneyId) {
  return request({
    url: '/system/money/' + moneyId,
    method: 'get'
  })
}

// 新增客人收入支出
export function addMoney(data) {
  return request({
    url: '/system/money',
    method: 'post',
    data: data
  })
}

// 修改客人收入支出
export function updateMoney(data) {
  return request({
    url: '/system/money',
    method: 'put',
    data: data
  })
}

// 删除客人收入支出
export function delMoney(moneyId) {
  return request({
    url: '/system/money/' + moneyId,
    method: 'delete'
  })
}
