package com.zjmy.account.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zjmy.account.interfaces.UserService;
import com.zjmy.account.model.User;
import com.zjmy.account.resource.UserResource;

@Api(value = "修改用户信息", description = "修改用户的基本信息")
@RestController
public class AccountCommandsController {

	@Autowired
	private UserService service;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return
	 */
	@ApiOperation(value = "创建用户", notes = "根据传过来的User实体信息来创建对象")
	@ApiImplicitParam(name = "user", value = "实体信息", required = true, dataType = "User")
	@RequestMapping(value = AccountRestCommon.USERS, method = RequestMethod.POST)
	public ResponseEntity<UserResource> addUser(@RequestBody User user) {
		logger.info("添加用户开始:" + new Date());
		User u = service.addUser(user);
		UserResource resource = new UserResource();
		resource.setUser(u);
		logger.info("添加用户结束:" + new Date());
		return new ResponseEntity<UserResource>(resource, HttpStatus.CREATED);
	}

	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "更新用户信息", notes = "根据url的id来指定更新对象,并根据传过来的user信息来更新用户详细信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long"),
		@ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
	})
	@RequestMapping(value = AccountRestCommon.USER, method = RequestMethod.PUT)
	public ResponseEntity<UserResource> update(@PathVariable Long id,
			@RequestBody User user) {
		User result = service.update(user);
		UserResource resource = new UserResource();
		resource.setUser(result);
		return new ResponseEntity<UserResource>(resource, HttpStatus.OK);
	}
}
