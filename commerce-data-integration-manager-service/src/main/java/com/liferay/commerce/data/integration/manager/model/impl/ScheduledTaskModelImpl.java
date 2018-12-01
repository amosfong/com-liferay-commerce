/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.data.integration.manager.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.data.integration.manager.model.ScheduledTask;
import com.liferay.commerce.data.integration.manager.model.ScheduledTaskModel;
import com.liferay.commerce.data.integration.manager.model.ScheduledTaskSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ScheduledTask service. Represents a row in the &quot;ScheduledTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ScheduledTaskModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ScheduledTaskImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ScheduledTaskImpl
 * @see ScheduledTask
 * @see ScheduledTaskModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class ScheduledTaskModelImpl extends BaseModelImpl<ScheduledTask>
	implements ScheduledTaskModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a scheduled task model instance should use the {@link ScheduledTask} interface instead.
	 */
	public static final String TABLE_NAME = "ScheduledTask";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "scheduledTaskId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "frequency", Types.VARCHAR },
			{ "processId", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "active_", Types.BOOLEAN },
			{ "runStartDate", Types.TIMESTAMP },
			{ "runEndDate", Types.TIMESTAMP },
			{ "startDate", Types.TIMESTAMP },
			{ "startHour", Types.VARCHAR },
			{ "enabled", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("scheduledTaskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("frequency", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("processId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("runStartDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("runEndDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("startHour", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("enabled", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table ScheduledTask (uuid_ VARCHAR(75) null,scheduledTaskId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,frequency VARCHAR(75) null,processId LONG,status INTEGER,active_ BOOLEAN,runStartDate DATE null,runEndDate DATE null,startDate DATE null,startHour VARCHAR(75) null,enabled BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table ScheduledTask";
	public static final String ORDER_BY_JPQL = " ORDER BY scheduledTask.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY ScheduledTask.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.com.liferay.data.integration.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.data.integration.model.ScheduledTask"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.com.liferay.data.integration.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.data.integration.model.ScheduledTask"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.com.liferay.data.integration.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.data.integration.model.ScheduledTask"),
			true);
	public static final long ACTIVE_COLUMN_BITMASK = 1L;
	public static final long COMPANYID_COLUMN_BITMASK = 2L;
	public static final long ENABLED_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long NAME_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ScheduledTask toModel(ScheduledTaskSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ScheduledTask model = new ScheduledTaskImpl();

		model.setUuid(soapModel.getUuid());
		model.setScheduledTaskId(soapModel.getScheduledTaskId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setFrequency(soapModel.getFrequency());
		model.setProcessId(soapModel.getProcessId());
		model.setStatus(soapModel.getStatus());
		model.setActive(soapModel.isActive());
		model.setRunStartDate(soapModel.getRunStartDate());
		model.setRunEndDate(soapModel.getRunEndDate());
		model.setStartDate(soapModel.getStartDate());
		model.setStartHour(soapModel.getStartHour());
		model.setEnabled(soapModel.isEnabled());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ScheduledTask> toModels(ScheduledTaskSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ScheduledTask> models = new ArrayList<ScheduledTask>(soapModels.length);

		for (ScheduledTaskSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.com.liferay.data.integration.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.data.integration.model.ScheduledTask"));

	public ScheduledTaskModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _scheduledTaskId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScheduledTaskId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scheduledTaskId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ScheduledTask.class;
	}

	@Override
	public String getModelClassName() {
		return ScheduledTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("scheduledTaskId", getScheduledTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("frequency", getFrequency());
		attributes.put("processId", getProcessId());
		attributes.put("status", getStatus());
		attributes.put("active", isActive());
		attributes.put("runStartDate", getRunStartDate());
		attributes.put("runEndDate", getRunEndDate());
		attributes.put("startDate", getStartDate());
		attributes.put("startHour", getStartHour());
		attributes.put("enabled", isEnabled());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long scheduledTaskId = (Long)attributes.get("scheduledTaskId");

		if (scheduledTaskId != null) {
			setScheduledTaskId(scheduledTaskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String frequency = (String)attributes.get("frequency");

		if (frequency != null) {
			setFrequency(frequency);
		}

		Long processId = (Long)attributes.get("processId");

		if (processId != null) {
			setProcessId(processId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date runStartDate = (Date)attributes.get("runStartDate");

		if (runStartDate != null) {
			setRunStartDate(runStartDate);
		}

		Date runEndDate = (Date)attributes.get("runEndDate");

		if (runEndDate != null) {
			setRunEndDate(runEndDate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String startHour = (String)attributes.get("startHour");

		if (startHour != null) {
			setStartHour(startHour);
		}

		Boolean enabled = (Boolean)attributes.get("enabled");

		if (enabled != null) {
			setEnabled(enabled);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getScheduledTaskId() {
		return _scheduledTaskId;
	}

	@Override
	public void setScheduledTaskId(long scheduledTaskId) {
		_scheduledTaskId = scheduledTaskId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getFrequency() {
		if (_frequency == null) {
			return "";
		}
		else {
			return _frequency;
		}
	}

	@Override
	public void setFrequency(String frequency) {
		_frequency = frequency;
	}

	@JSON
	@Override
	public long getProcessId() {
		return _processId;
	}

	@Override
	public void setProcessId(long processId) {
		_processId = processId;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	@JSON
	@Override
	public Date getRunStartDate() {
		return _runStartDate;
	}

	@Override
	public void setRunStartDate(Date runStartDate) {
		_runStartDate = runStartDate;
	}

	@JSON
	@Override
	public Date getRunEndDate() {
		return _runEndDate;
	}

	@Override
	public void setRunEndDate(Date runEndDate) {
		_runEndDate = runEndDate;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public String getStartHour() {
		if (_startHour == null) {
			return "";
		}
		else {
			return _startHour;
		}
	}

	@Override
	public void setStartHour(String startHour) {
		_startHour = startHour;
	}

	@JSON
	@Override
	public boolean getEnabled() {
		return _enabled;
	}

	@JSON
	@Override
	public boolean isEnabled() {
		return _enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		_columnBitmask |= ENABLED_COLUMN_BITMASK;

		if (!_setOriginalEnabled) {
			_setOriginalEnabled = true;

			_originalEnabled = _enabled;
		}

		_enabled = enabled;
	}

	public boolean getOriginalEnabled() {
		return _originalEnabled;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ScheduledTask.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ScheduledTask.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ScheduledTask toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ScheduledTask)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ScheduledTaskImpl scheduledTaskImpl = new ScheduledTaskImpl();

		scheduledTaskImpl.setUuid(getUuid());
		scheduledTaskImpl.setScheduledTaskId(getScheduledTaskId());
		scheduledTaskImpl.setGroupId(getGroupId());
		scheduledTaskImpl.setCompanyId(getCompanyId());
		scheduledTaskImpl.setUserId(getUserId());
		scheduledTaskImpl.setUserName(getUserName());
		scheduledTaskImpl.setCreateDate(getCreateDate());
		scheduledTaskImpl.setModifiedDate(getModifiedDate());
		scheduledTaskImpl.setName(getName());
		scheduledTaskImpl.setFrequency(getFrequency());
		scheduledTaskImpl.setProcessId(getProcessId());
		scheduledTaskImpl.setStatus(getStatus());
		scheduledTaskImpl.setActive(isActive());
		scheduledTaskImpl.setRunStartDate(getRunStartDate());
		scheduledTaskImpl.setRunEndDate(getRunEndDate());
		scheduledTaskImpl.setStartDate(getStartDate());
		scheduledTaskImpl.setStartHour(getStartHour());
		scheduledTaskImpl.setEnabled(isEnabled());

		scheduledTaskImpl.resetOriginalValues();

		return scheduledTaskImpl;
	}

	@Override
	public int compareTo(ScheduledTask scheduledTask) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				scheduledTask.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScheduledTask)) {
			return false;
		}

		ScheduledTask scheduledTask = (ScheduledTask)obj;

		long primaryKey = scheduledTask.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ScheduledTaskModelImpl scheduledTaskModelImpl = this;

		scheduledTaskModelImpl._originalUuid = scheduledTaskModelImpl._uuid;

		scheduledTaskModelImpl._originalGroupId = scheduledTaskModelImpl._groupId;

		scheduledTaskModelImpl._setOriginalGroupId = false;

		scheduledTaskModelImpl._originalCompanyId = scheduledTaskModelImpl._companyId;

		scheduledTaskModelImpl._setOriginalCompanyId = false;

		scheduledTaskModelImpl._setModifiedDate = false;

		scheduledTaskModelImpl._originalName = scheduledTaskModelImpl._name;

		scheduledTaskModelImpl._originalActive = scheduledTaskModelImpl._active;

		scheduledTaskModelImpl._setOriginalActive = false;

		scheduledTaskModelImpl._originalEnabled = scheduledTaskModelImpl._enabled;

		scheduledTaskModelImpl._setOriginalEnabled = false;

		scheduledTaskModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ScheduledTask> toCacheModel() {
		ScheduledTaskCacheModel scheduledTaskCacheModel = new ScheduledTaskCacheModel();

		scheduledTaskCacheModel.uuid = getUuid();

		String uuid = scheduledTaskCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			scheduledTaskCacheModel.uuid = null;
		}

		scheduledTaskCacheModel.scheduledTaskId = getScheduledTaskId();

		scheduledTaskCacheModel.groupId = getGroupId();

		scheduledTaskCacheModel.companyId = getCompanyId();

		scheduledTaskCacheModel.userId = getUserId();

		scheduledTaskCacheModel.userName = getUserName();

		String userName = scheduledTaskCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			scheduledTaskCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			scheduledTaskCacheModel.createDate = createDate.getTime();
		}
		else {
			scheduledTaskCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			scheduledTaskCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			scheduledTaskCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		scheduledTaskCacheModel.name = getName();

		String name = scheduledTaskCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			scheduledTaskCacheModel.name = null;
		}

		scheduledTaskCacheModel.frequency = getFrequency();

		String frequency = scheduledTaskCacheModel.frequency;

		if ((frequency != null) && (frequency.length() == 0)) {
			scheduledTaskCacheModel.frequency = null;
		}

		scheduledTaskCacheModel.processId = getProcessId();

		scheduledTaskCacheModel.status = getStatus();

		scheduledTaskCacheModel.active = isActive();

		Date runStartDate = getRunStartDate();

		if (runStartDate != null) {
			scheduledTaskCacheModel.runStartDate = runStartDate.getTime();
		}
		else {
			scheduledTaskCacheModel.runStartDate = Long.MIN_VALUE;
		}

		Date runEndDate = getRunEndDate();

		if (runEndDate != null) {
			scheduledTaskCacheModel.runEndDate = runEndDate.getTime();
		}
		else {
			scheduledTaskCacheModel.runEndDate = Long.MIN_VALUE;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			scheduledTaskCacheModel.startDate = startDate.getTime();
		}
		else {
			scheduledTaskCacheModel.startDate = Long.MIN_VALUE;
		}

		scheduledTaskCacheModel.startHour = getStartHour();

		String startHour = scheduledTaskCacheModel.startHour;

		if ((startHour != null) && (startHour.length() == 0)) {
			scheduledTaskCacheModel.startHour = null;
		}

		scheduledTaskCacheModel.enabled = isEnabled();

		return scheduledTaskCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", scheduledTaskId=");
		sb.append(getScheduledTaskId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", frequency=");
		sb.append(getFrequency());
		sb.append(", processId=");
		sb.append(getProcessId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", active=");
		sb.append(isActive());
		sb.append(", runStartDate=");
		sb.append(getRunStartDate());
		sb.append(", runEndDate=");
		sb.append(getRunEndDate());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", startHour=");
		sb.append(getStartHour());
		sb.append(", enabled=");
		sb.append(isEnabled());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.liferay.data.integration.model.ScheduledTask");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduledTaskId</column-name><column-value><![CDATA[");
		sb.append(getScheduledTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frequency</column-name><column-value><![CDATA[");
		sb.append(getFrequency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processId</column-name><column-value><![CDATA[");
		sb.append(getProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(isActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>runStartDate</column-name><column-value><![CDATA[");
		sb.append(getRunStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>runEndDate</column-name><column-value><![CDATA[");
		sb.append(getRunEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startHour</column-name><column-value><![CDATA[");
		sb.append(getStartHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enabled</column-name><column-value><![CDATA[");
		sb.append(isEnabled());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ScheduledTask.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ScheduledTask.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _scheduledTaskId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _originalName;
	private String _frequency;
	private long _processId;
	private int _status;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private Date _runStartDate;
	private Date _runEndDate;
	private Date _startDate;
	private String _startHour;
	private boolean _enabled;
	private boolean _originalEnabled;
	private boolean _setOriginalEnabled;
	private long _columnBitmask;
	private ScheduledTask _escapedModel;
}