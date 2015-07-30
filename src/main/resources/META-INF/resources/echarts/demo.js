var echart_j_idt16 = echarts.init(document.getElementById('j_idt16'));
echart_j_idt16.showLoading({
	text : 'loading...'
});
echart_j_idt16.hideLoading();
echart_j_idt16.setOption({
	calculable : true,
	renderAsImage : false,
	calculable : true,
	animation : true,
	title : {
		text : '标准安全层面分布',
		subtext : '',
		x : 'center'
	},
	tooltip : {
		trigger : 'item',
		formatter : "{a} <br/>{b} : {c}"
	},
	grid : {
		x : 200,
		y : 60,
		x2 : 80,
		y2 : 60
	},
	legend : {
		orient : 'vertical',
		x : 'left',
		y : 'top',
		itemGap : 10,
		data : [ '物理安全', '网络安全', '主机安全', '应用软件', '数据保护安全', '安全集中管控', '密码技术',
				'终端安全', '安全运维管理', '安全管理机构', '安全管理制度', '安全变更管理', '安全等级保护管理',
				'人员安全管理', '安全建设管理', '密码管理', '安全集中管控技术' ]
	},
	toolbox : {
		show : true,
		feature : {
			mark : {
				show : true
			},
			dataView : {
				show : true,
				readOnly : false
			},
			restore : {
				show : true
			},
			saveAsImage : {
				show : true
			}
		}
	},
	series : [ {
		name : 'null',
		type : 'pie',
		radius : '55%',
		center : [ '50%', '60%' ],
		data : [ {
			value : 137,
			name : '物理安全'
		}, {
			value : 207,
			name : '网络安全'
		}, {
			value : 608,
			name : '主机安全'
		}, {
			value : 498,
			name : '应用软件'
		}, {
			value : 153,
			name : '数据保护安全'
		}, {
			value : 66,
			name : '安全集中管控'
		}, {
			value : 18,
			name : '密码技术'
		}, {
			value : 0,
			name : '终端安全'
		}, {
			value : 170,
			name : '安全运维管理'
		}, {
			value : 42,
			name : '安全管理机构'
		}, {
			value : 28,
			name : '安全管理制度'
		}, {
			value : 16,
			name : '安全变更管理'
		}, {
			value : 38,
			name : '安全等级保护管理'
		}, {
			value : 44,
			name : '人员安全管理'
		}, {
			value : 94,
			name : '安全建设管理'
		}, {
			value : 10,
			name : '密码管理'
		}, {
			value : 0,
			name : '安全集中管控技术'
		} ]
	} ]
});