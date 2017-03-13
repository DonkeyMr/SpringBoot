package com.zjmy.account.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zjmy.account.interfaces.UserService;
import com.zjmy.account.model.User;
import com.zjmy.account.resource.UserResource;

@Api(value = "用户查询", description = "查询用户信息")
@RestController
public class AccountQueriesController {

	@Autowired
	private UserService userService;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * 获取用户详细信息
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "获取用户详细信息", notes = "根据url中的id获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
	@RequestMapping(value = AccountRestCommon.USER, method = RequestMethod.GET)
	public ResponseEntity<UserResource> get(@PathVariable Long id) {
		User user = userService.get(id);
		UserResource resource = new UserResource();
		resource.setUser(user);
		return new ResponseEntity<UserResource>(resource, HttpStatus.OK);
	}
	
	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = AccountRestCommon.USERS, method = RequestMethod.GET)
	public List<User> getUserList() {
		logger.info("查询学生列表开始：" + new Date());
		List<User> list = userService.getUserList();
		logger.info("查询学生列表结束：" + new Date());
		return list;
	}
}
