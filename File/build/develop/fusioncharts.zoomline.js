!function(e){"object"==typeof module&&"undefined"!=typeof module.exports?module.exports=e:e()}((function(){(window.webpackJsonpFusionCharts=window.webpackJsonpFusionCharts||[]).push([[6],{1110:function(e,t,i){"use strict";var n=i(178);t.__esModule=!0,t["default"]=void 0;var o=n(i(1111));t.ZoomLine=o["default"];var a=n(i(1117));t.ZoomLineDY=a["default"];var s=n(i(1120)),r={name:"zoomline",type:"package",requiresFusionCharts:!0,extension:function(e){e.addDep(s["default"]),e.addDep(o["default"]),e.addDep(a["default"])}};t["default"]=r},1111:function(e,t,i){"use strict";var n=i(178);t.__esModule=!0,t["default"]=void 0;var o=n(i(1112))["default"];t["default"]=o},1112:function(e,t,i){"use strict";var n=i(178);t.__esModule=!0,t["default"]=void 0;var o=n(i(198)),a=i(184),s=n(i(655)),r=n(i(1113)),l=n(i(1115)),c=i(196),u=i(567),h=i(1116),d=i(192),p=window.navigator.userAgent,g=(0,d.getDep)("redraphael","plugin"),f=window.doc,m="rgba(192,192,192,"+(/msie/i.test(p)&&!window.opera?.002:1e-6)+")",v=window.parseFloat,b=window.parseInt,x=Math,C=x.max,y=x.min,k=x.ceil,w=x.floor,E=0,M=function(e,t){var i=t.get("config"),n=(0,a.getMouseCoordinate)(t.get("linkedItems","container"),e,t),o=n.chartX,s=n.chartY,r=i.canvasLeft,l=i.canvasTop,c=i.canvasLeft+i.canvasWidth,u=i.canvasHeight+i.canvasTop;return n.insideCanvas=!1,n.originalEvent=e,o>r&&o<c&&s>l&&s<u&&(n.insideCanvas=!0),n};g.addSymbol(h.symbolList);var P=function(e){function t(){var t;return(t=e.call(this)||this).zoomX=!0,t.hasScroll=!0,t.eiMethods={zoomOut:function(e){var t,i=this.apiInstance,n=i.getChildren&&i.getChildren("canvas")[0],o=n&&n.getChildren("inputManager");o=o&&o[0],i&&o&&i.addJob("zoomOut"+E++,(function(){t=o.zoomOut(),"function"==typeof e&&e(t)}),c.priorityList.postRender)},zoomTo:function(e,t,i){var n,o=this.apiInstance,s=o.getChildren&&o.getChildren("canvas")[0],r=s&&s.getChildren("inputManager");if(e!==a.UNDEF&&t!==a.UNDEF&&(r=r&&r[0],o&&r))return i?void o.addJob("zoomTo"+E++,(function(){n=r.zoomTo(e,t),"function"==typeof i&&i(n)}),c.priorityList.postRender):r.zoomTo(e,t)},resetChart:function(){var e=this.apiInstance,t=e.getChildren&&e.getChildren("canvas")[0],i=t&&t.getChildren("inputManager");i=i&&i[0],e&&i&&e.addJob("resetChart"+E++,(function(){i.resetChart()}),c.priorityList.postRender)},setZoomMode:function(e){var t=this.apiInstance,i=t.getChildren&&t.getChildren("canvas")[0],n=i&&i.getChildren("inputManager");n=n&&n[0],t&&n&&t.addJob("setZoomMode"+E++,(function(){n.setZoomMode(e)}),c.priorityList.postRender)},getViewStartIndex:function(e){var t,i,n,o=this.apiInstance;if(!e)return t=o.getChildren("xAxis")[0],i=t.getVisibleConfig().minValue,0===(n=Math.ceil(i))?0:n;o.addJob("getViewStartIndex"+E++,(function(){"function"==typeof e&&(t=o.getChildren("xAxis")[0],i=t.getVisibleConfig().minValue,n=Math.ceil(i),e(0===n?0:n))}),c.priorityList.postRender)},getViewEndIndex:function(e){var t,i,n=this.apiInstance;if(!e)return t=n.getChildren("xAxis")[0],i=t.getVisibleConfig().maxValue,Math.floor(i);n.addJob("getViewEndIndex"+E++,(function(){"function"==typeof e&&(t=n.getChildren("xAxis")[0],i=t.getVisibleConfig().maxValue,e(Math.floor(i)))}),c.priorityList.postRender)}},t.eiMethods.scrollTo=u.scrollTo,t.registerFactory("dataset",l["default"],["vCanvas"]),t}(0,o["default"])(t,e),t.getName=function(){return"ZoomLine"},t.includeInputOptions=function(){return["DragZoomIn","DragPin","ZoomResetButton","ZoomOutButton"]};var i=t.prototype;return i.__setDefaultConfig=function(){e.prototype.__setDefaultConfig.call(this);var t=this.config;t.friendlyName="Zoomable and Panable Multi-series Line Chart",t.defaultDatasetType="zoomline",t.showValues=0,t.zeroplanethickness=1,t.zeroplanealpha=40,t.showzeroplaneontop=0,t.enablemousetracking=!0,t.skipAttr=!0,t.canvasborderthickness=1,t.showvalues=0},i.getName=function(){return"ZoomLine"},i.parseChartAttr=function(t){e.prototype.parseChartAttr.call(this,t);var i=this.config,n=(t||this.getFromEnv("dataSource")).chart;i.useCrossline=Number(n.usecrossline)||n.usecrossline===a.UNDEF?1:0,i.drawTrendRegion=0},i.getInputConfigurations=function(){var e=this,t=e.config,i=function(i,n){e.addJob("inputZoom",(function(){var o=t.viewPortConfig;o.dsi=i,o.dei=n,e.updateManager(),e.getChildren("xAxis")[0].prepareAttributes()}),c.priorityList.configure)};return{dragZoomIn:{scaleX:!0,scaleY:!1,drawButton:!1,boxStyle:{stroke:t.zoomPaneStroke,fill:t.zoomPaneFill,"stroke-width":0},catZoomLimit:2,skipGraphics:!0,dragendFn:function(){return i(arguments.length<=1?undefined:arguments[1],arguments.length<=2?undefined:arguments[2])}},zoomResetButton:{hookFn:i,tooltext:t.btnResetChartTooltext},zoomOutButton:{hookFn:i,tooltext:t.btnZoomOutTooltext},dragPin:{orientation:"horizontal",attr:{stroke:t.zoomPaneStroke,fill:t.zoomPaneFill,"stroke-width":0},skipGraphics:!t.allowPinMode,pinAttr:{"stroke-width":0,stroke:"none",fill:t.pinPaneFill,"shape-rendering":"crisp"},strokeWidth:0,tooltext:t.showToolBarButtonTooltext&&t.btnSwitchToPinModeTooltext||""}}},i._setCategories=function(){var e,t,i,n,o=this.config,s=this.getFromEnv("dataSource"),r=s.chart||{},l=this.getChildren("xAxis"),c=o.cdm,u=o.cdmchar,h=s.categories&&s.categories[0].category||[];if(o.cdm=c=(0,a.pluckNumber)(r.compactdatamode,0),o.cdmchar=u=(0,a.pluck)(r.dataseparator,"|"),(c||"string"==typeof h)&&h.split){for(t=[],i=0,n=(e=h.split(u)).length;i<n;i+=1)t.push({label:e[i]});this.config.categories=s.categories[0].category=t}l[0].setAxisPadding(0,0),l[0].setTickValues(t||h)},i.isWithinCanvas=function(e,t){return M.call(this,e,t)},i.highlightPoint=function(e,t,i,n,o,a){var s,r,l,c,u,h,d=this,p=d.config,g=d.getFromEnv("animationManager"),v=d.components,b=d.graphics,x=Number(e),C=b.tracker,y=v.dataset[o],k=y&&y.config,w=y&&k.zoomedRadius||0,E=y&&k.hoverCosmetics,M=E&&E.fill,P=E&&E.borderColor,L=E&&E.borderThickness,_=function(e){d.plotEventHandler(this,e)},T=function(e){d.plotEventHandler(this,e,"dataplotRollover")},N=function(e){d.plotEventHandler(this,e,"dataplotRollout")};C||(s=b.tracker=g.setAnimation({el:"circle",attr:{cx:0,cy:0,r:w,fill:x?M:m,stroke:x?P:m,"stroke-width":x?L:0,"clip-rect":p.canvasLeft+","+p.canvasTop+","+p.canvasWidth+","+p.canvasHeight},container:b.trackerGroup,component:d}).on("fc-click",_).hover(T,N)),n&&s.data("eventArgs",{x:n.x,y:n.y,tooltip:n.tooltip,link:n.link}),p.lastHoveredPoint=n,d.getFromEnv("toolTipController").enableToolTip(s,a),s.transform("t"+(t+p.canvasLeft)+","+(i+p.canvasTop)),n&&(r="mouseover",l=s&&s.node,c=p.lastMouseEvent,h=c,l&&r&&(h||(h={}),h.originalEvent&&(h=h.originalEvent),h.touches&&(h=h.touches[0]),l.dispatchEvent?(MouseEvent?u=new MouseEvent(r,{bubbles:!!h.bubbles,cancelable:!!h.cancelable,clientX:h.clientX||h.pageX&&h.pageX-f.body.scrollLeft-f.documentElement.scrollLeft||0,clientY:h.clientY||h.pageY&&h.pageY-f.body.scrollTop-f.documentElement.scrollTop||0,screenX:h.screenX||0,screenY:h.screenY||0,pageX:h.pageX||0,pageY:h.pageY||0}):f.createEvent&&(u=f.createEvent("HTMLEvents")).initEvent(r,!!h.bubbles,!!h.cancelable),u.eventName=r,u&&l.dispatchEvent(u)):f.createEventObject&&l.fireEvent&&((u=f.createEventObject()).eventType=r,u.eventName=r,l.fireEvent("on"+r,u))))},i.configureAttributes=function(t){e.prototype.configureAttributes.call(this,t);var i,n,o=this.getFromEnv("dataSource").chart||{},s=this.getFromEnv("color-manager"),r=s.getColor("canvasBorderColor"),l=(0,a.pluckNumber)(o.showtoolbarbuttontooltext,1);i=(n=this.config).style,n.stepZoom=400/(100-(0,a.pluckNumber)(o.stepzoom,25)),n.stepZoom<=2&&(n.stepZoom=1.9),(0,a.extend2)(n,{useRoundEdges:(0,a.pluckNumber)(o.useroundedges,0),zoomType:"x",canvasPadding:(0,a.pluckNumber)(o.canvaspadding,0),scrollColor:(0,a.getFirstColor)((0,a.pluck)(o.scrollcolor,s.getColor("altHGridColor"))),scrollShowButtons:!!(0,a.pluckNumber)(o.scrollshowbuttons,1),scrollHeight:(0,a.pluckNumber)(o.scrollheight,16)||16,scrollBarFlat:(0,a.pluckNumber)(o.flatscrollbars,0),allowPinMode:(0,a.pluckNumber)(o.allowpinmode,1),skipOverlapPoints:(0,a.pluckNumber)(o.skipoverlappoints,1),showToolBarButtonTooltext:l,btnResetChartTooltext:l?(0,a.pluck)(o.btnresetcharttooltext,"Reset Chart"):"",btnZoomOutTooltext:l?(0,a.pluck)(o.btnzoomouttooltext,"Zoom out one level"):"",btnSwitchToZoomModeTooltext:l?(0,a.pluck)(o.btnswitchtozoommodetooltext,"<strong>Switch to Zoom Mode</strong><br/>Select a subset of data to zoom into it for detailed view"):"",btnSwitchToPinModeTooltext:l?(0,a.pluck)(o.btnswitchtopinmodetooltext,"<strong>Switch to Pin Mode</strong><br/>Select a subset of data and compare with the rest of the view"):"",pinPaneFill:(0,a.convertColor)((0,a.pluck)(o.pinpanebgcolor,r),(0,a.pluckNumber)(o.pinpanebgalpha,15)),zoomPaneFill:(0,a.convertColor)((0,a.pluck)(o.zoompanebgcolor,"#b9d5f1"),(0,a.pluckNumber)(o.zoompanebgalpha,30)),zoomPaneStroke:(0,a.convertColor)((0,a.pluck)(o.zoompanebordercolor,"#3399ff"),(0,a.pluckNumber)(o.zoompaneborderalpha,80)),showPeakData:(0,a.pluckNumber)(o.showpeakdata,0),maxPeakDataLimit:(0,a.pluckNumber)(o.maxpeakdatalimit,o.maxpeaklimit,null),minPeakDataLimit:(0,a.pluckNumber)(o.minpeakdatalimit,o.minpeaklimit,null),crossline:{enabled:(0,a.pluckNumber)(o.showcrossline,1),line:{"stroke-width":(0,a.pluckNumber)(o.crosslinethickness,1),stroke:(0,a.getFirstColor)((0,a.pluck)(o.crosslinecolor,"#000000")),"stroke-opacity":(0,a.pluckNumber)(o.crosslinealpha,20)/100},labelEnabled:(0,a.pluckNumber)(o.showcrosslinelabel,o.showcrossline,1),labelstyle:{fontSize:v(o.crosslinelabelsize)?v(o.crosslinelabelsize)+"px":i.outCanfontSize,fontFamily:(0,a.pluck)(o.crosslinelabelfont,i.outCanfontFamily)},valueEnabled:(0,a.pluckNumber)(o.showcrosslinevalues,o.showcrossline,1),valuestyle:{fontSize:v(o.crosslinevaluesize)?v(o.crosslinevaluesize)+"px":i.inCanfontSize,fontFamily:(0,a.pluck)(o.crosslinevaluefont,i.inCanvasStyle.fontFamily)}},useCrossline:(0,a.pluckNumber)(o.usecrossline,1),tooltipSepChar:(0,a.pluck)(o.tooltipsepchar,", "),showTerminalValidData:(0,a.pluckNumber)(o.showterminalvaliddata,0)})},i.getValuePixel=function(e){var t=this.config.viewPortConfig;return t.ddsi+w(e/t.ppp)},i.getDatasets=function(){var e=[];return this.iterateComponents((function(t){t.getType&&"dataset"===t.getType()&&e.push(t)})),e},i.__preDraw=function(){var e,t,i,n,o,s=this.config,r=this.getFromEnv("dataSource").chart,l=s.cdm,c=this.getChildren("xAxis")[0],u=s.viewPortConfig,h=this.getChildren("canvas")[0].config,d=C(h.canvasPadding,h.canvasPaddingLeft,h.canvasPaddingRight),p=this.getChildren("yAxis")[0],g=s.canvasHeight,f=this.getFromEnv("dataSource").chart,m=c.getTicksLen(),v=c.getVisibleConfig(),x=v.minValue,y=v.maxValue,k=(0,a.pluckNumber)(r.displaystartindex,x,1),w=(0,a.pluckNumber)(r.displayendindex,y,m||2),E=b(k,10)-1,M=b(w,10)-1,P=0;if(o=(n=this.getDatasets()).length,s.borderWidth=(0,a.pluckNumber)(f.showborder,1)?(0,a.pluckNumber)(f.borderthickness,1):0,s.updateAnimDuration=500,s.status="zoom",s.maxZoomLimit=(0,a.pluckNumber)(r.maxzoomlimit,1e3),s.viewPortHistory=[],(t=(0,a.pluckNumber)(r.pixelsperpoint,15))<1&&(t=1),(i=(0,a.pluckNumber)(r.pixelsperlabel,r.xaxisminlabelwidth,c.getAxisConfig("labels").rotation?20:60))<t&&(i=t),(E<0||E>=(m-1||1))&&(E=0),(M<=E||M>(m-1||1))&&(M=m-1||1),(u=s.viewPortConfig=(0,a.extend2)(s.viewPortConfig,{amrd:(0,a.pluckNumber)(r.anchorminrenderdistance,20),nvl:(0,a.pluckNumber)(r.numvisiblelabels,0),cdm:l,oppp:t,oppl:i,dsi:E,dei:M,vdl:M-E,clen:m,offset:0,step:1,llen:0,alen:0,ddsi:E,ddei:M,ppc:0})).clen){for(;o--;)e=n[o].config,P=C(P,e.drawanchors&&(e.anchorradius||0)+(Number(e.anchorborderthickness)||0)||0);s.overFlowingMarkerWidth=P,d=s.canvasPadding=C(P,d),s._prezoomed=u.dei-u.dsi<u.clen-1,s._visw=Math.max(1,s.canvasWidth-2*d),s._visx=s.canvasLeft+d,s._visout=-(s.height+g+1e3),s._yminValue=p.getLimit().min,s._ymin=p.getPixel(s._yminValue),(0,a.pluckNumber)(r.displaystartindex,r.displayendindex)&&c.setVisibleConfig(k,w),this.updateManager()}},i.resetZoom=function(){var e=this.config.viewPortHistory,t=e[0];return!!e.length&&(e.length=0,this.zoomTo(t.dsi,t.dei,t)&&this.fireChartInstanceEvent("zoomReset",this._zoomargs,[this.getFromEnv("chartInstance").id]),!0)},i.zoomOut=function(){var e,t,i,n,o,a=this.config,s=a.viewPortHistory;return e=s.pop(),t=s[0]||a.viewPortConfig,e?(i=e.dsi,n=e.dei):a._prezoomed&&(i=0,n=t.clen-1),(o=this.zoomTo(i,n,e))&&this.fireChartInstanceEvent("zoomedout",o),!0},i.zoomRangePixels=function(e,t){var i,n,o=this.config.viewPortConfig,a=o.ppp,s=o.ddsi;i=s+w(e/a),n=s+w(t/a),o.dsi=i,o.dei=n,this.updateManager()},i.prepareAttributes=function(){this.config.hasChartMessage||(this.__preDraw(),e.prototype.prepareAttributes.call(this))},i.getValue=function(e){var t=this.config,i=t.viewPortConfig,n=this.getOriginalPositions(e.x,e.y,e.x,e.y),o=n[0],a=n[1],s=this.getChildren("xAxis")[0],r=this.getChildren("yAxis")[0],l=s.config.axisRange,c=r.config.axisRange,u=l.min,h=l.max,d=c.max,p=c.min,g=t.canvasWidth*i.scaleX/(h-u),f=t.canvasHeight*i.scaleY/(d-p);return{x:u+(o-t.canvasLeft)/g,y:d-(a-t.canvasTop)/f}},i.getOriginalPositions=function(e,t,i,n){var o=this.config,a=o.viewPortConfig,s=a.scaleX,r=a.scaleY,l=a.x,c=a.y,u=y(e,i),h=C(e,i),d=y(t,n),p=C(t,n);return[l+(u=u<0?0:u)/s,c+(d=d<0?0:d)/r,((h=h>o.canvasWidth?o.canvasWidth:h)-u)/s,((p=p>o.canvasHeight?o.canvasHeight:p)-d)/r]},i.updateManager=function(){var e,t,i,n,o,a,s,r,l,c,u,h,d,p,g,f,m,b=this.getDatasets(),x=b.length,y=this.config,w=y.viewPortConfig,E=y._visw,M=this.getChildren("xAxis")[0],P=function(e){return M.getPixel(e,{wrtVisible:!0})},L=M.getAxisConfig("labels").style;if(y.legendClicked)for(e=0;e<x;e+=1)b[e].draw();else!w&&(w=y.viewPortConfig),o=w.oppp,f=w.nvl,h=w.dsi,d=w.dei,a=w.vdl=d-h,s=w.ppl=f?E/f:w.oppl,l=w.step=(r=w.ppp=E/a)<o?k(o/r):1,c=w.lskip=k(C(s,v(L.lineHeight))/r/l),p=w.dsi,g=w.dei,w.offset=0,u=w.norm=p%l,w.ddsi=p-=u,w.ddei=g=g+2*l-u,w._ymin=y._ymin,w._yminValue=y._yminValue,w.x=(P(p)-P(M.getVisibleConfig().minValue)+w.offset)/w.scaleX,g-p>M.getTicksLen()?w.scaleX=1:w.scaleX=M.getTicksLen()/Math.abs(g-p-l-.9),m=M.getVisibleConfig(),i=Math.ceil((m.maxValue-m.minValue+1)/f),n=y.viewPortConfig&&y.viewPortConfig.scaleX,t=Math.max(Math.round(M.getAxisConfig("labelStep")/n),f?i:c*l),M.setLabelConfig({step:t})},i.getParsedLabel=function(e){var t=this.xlabels;return t.parsed[e]||(t.parsed[e]=(0,a.parseUnsafeString)(t.data[e]||""))},i._setAxisScale=function(){this.getChildren("xAxis")[0].setScrollType("always")},i.getDSdef=function(){return r["default"]},t}(s["default"]);t["default"]=P},1113:function(e,t,i){"use strict";var n=i(178);t.__esModule=!0,t["default"]=void 0;var o=n(i(198)),a=i(184),s=n(i(498)),r=i(192),l=n(i(1114)),c=a.hasTouch?a.TOUCH_THRESHOLD_PIXELS:a.CLICK_THRESHOLD_PIXELS;(0,r.addDep)({name:"zoomlineAnimation",type:"animationRule",extension:l["default"]});var u=function(e){function t(){return e.apply(this,arguments)||this}(0,o["default"])(t,e);var i=t.prototype;return i.getType=function(){return"dataset"},i.getName=function(){return"zoomLine"},i.__setDefaultConfig=function(){e.prototype.__setDefaultConfig.call(this),this.config.skipIgnorerIndices=[],this.config.showPeakData=0,this.config.showTerminalValidData=0,this.config.minPeakDataLimit=null,this.config.maxPeakDataLimit=null},i._plotConfigure=function(t,i,n){e.prototype._plotConfigure.call(this,t,i,n);var o=this.config,a=this.components.data[t].config.setValue,s=n||this.getFromEnv("xAxis").getTicksLen(),r=o.showTerminalValidData,l=o.showPeakData,c=o.maxPeakDataLimit,u=o.minPeakDataLimit,h=c>u,d=a>c||a<u;l&&(c<u&&(a>c&&a<u)?o.skipIgnorerIndices.push(t):h&&d&&o.skipIgnorerIndices.push(t)),r&&t===s-1&&o.skipIgnorerIndices.push(t)},i.drawPlots=function(){var t=this.getFromEnv("xAxis"),i=this.getFromEnv("chartConfig").viewPortConfig;t.getPixel(i.step)-t.getPixel(0)>=i.amrd?e.prototype.drawPlots.call(this):this.hideAllAnchors()},i._setConfigure=function(t,i){var n=this.config,o=this.getFromEnv("chart"),s=o.config,r=o.getFromEnv("dataSource").chart,l=this.config.JSONData;n.drawanchors=(0,a.pluckNumber)(r.drawanchors,r.showanchors,1),n.anchorradius=(0,a.pluckNumber)(l.anchorradius,r.anchorradius,n.linethickness+2),n.showTerminalValidData=(0,a.pluckNumber)(s.showTerminalValidData,0),n.showPeakData=(0,a.pluckNumber)(s.showPeakData,0),n.showPeakData&&(s.maxPeakDataLimit||s.minPeakDataLimit)&&(n.maxPeakDataLimit=(0,a.pluckNumber)(s.maxPeakDataLimit,Number.MIN_SAFE_INTEGER),n.minPeakDataLimit=(0,a.pluckNumber)(s.minPeakDataLimit,Number.MAX_SAFE_INTEGER)),e.prototype._setConfigure.call(this,t,i)},i.configureAttributes=function(t){e.prototype.configureAttributes.call(this,t);var i,n,o={},s=this.getFromEnv("chart").getFromEnv("dataSource").chart;i=(n=this.config).linethickness+(0,a.pluckNumber)(s.pinlinethicknessdelta,1),o["stroke-width"]=i>0&&i||0,o["stroke-dasharray"]=[3,2],o.stroke=(0,a.hashify)(n.linecolor),o["stroke-opacity"]=n.alpha/100,o["stroke-linejoin"]=n["stroke-linejoin"]="round",o["stroke-linecap"]=n["stroke-linecap"]="round",n.pin=o,n.animation=!1,n.transposeanimduration=0,n.defaultPadding={left:0,right:0}},i.drawLabel=function(){return this},i.isWithinShape=function(e,t,i,n){var o,s,r,l,u,h,d,p,g,f,m,v;if(e)return o=e.config.anchorProps,s=e.config,l=o.borderThickness,this,u=this.components.data,h=(0,a.pluckNumber)(s.dragTolerance,0),d=e._xPos,null!==(p=e._yPos)?(v=e.config.hoverEffects,r=Math.max(o.radius,v&&v.anchorRadius||0,c)+l/2,g=i-d,f=n-p,((m=Math.sqrt(Math.pow(g,2)+Math.pow(f,2)))<=r||m<=h)&&{pointIndex:t,hovered:!0,pointObj:u[t]}):void 0},i.hideAllAnchors=function(){var e,t,i,n=this.components.data;for(t=0,i=n.length;t<i;t++)(e=n[t])&&e.graphics&&e.graphics.element&&e.graphics.element.hide()},i._firePlotEvent=function(e,t,i){var n,o,a,s=this.getFromEnv("chart"),r=this.components.data,l=this.getFromEnv("toolTipController"),c=r[t],u=c.graphics.element,h=this.config.currentToolTip,d=!s.config.useCrossline;switch(a=(n=c.config).setLink,o=n.eventArgs,e){case"fc-mouseover":d&&this._decideTooltipType(t,i),this._rolloverResponseSetter(s,c,i),a&&(u.node.style.cursor="pointer");break;case"fc-mouseout":l.hide(h),this._rolloutResponseSetter(s,c,i),a&&(u.node.style.cursor="default");break;case"fc-click":s.plotEventHandler(u,i,"dataplotclick",o);break;case"fc-mousemove":d&&this._decideTooltipType(t,i)}},i.calculateScrollRange=function(){var e=this.config,t=this.getFromEnv("xAxis"),i=t.getTicksLen(),n=this.getFromEnv("chartConfig").viewPortConfig.step||1;e.scrollMinVal=Math.max(Math.round(t.getVisibleConfig().minValue),0)-n,e.scrollMaxVal=Math.min(Math.round(t.getVisibleConfig().maxValue)+1,i)+n,e.scrollMinValForLabel=Math.max(Math.round(t.getVisibleConfig().minValue),0)-n,e.scrollMaxValForLabel=Math.min(Math.round(t.getVisibleConfig().maxValue)+1,i)+n,e.scrollMinVal-=e.scrollMinVal%n,e.scrollMinValForLabel-=e.scrollMinValForLabel%n},t}(s["default"]);t["default"]=u},1114:function(e,t,i){"use strict";var n=i(178);t.__esModule=!0,t["default"]=void 0;var o={"initial.dataset.zoomLine":n(i(501))["default"]["initial.dataset.line"]};t["default"]=o},1115:function(e,t,i){"use strict";t.__esModule=!0,t["default"]=function(e){var t,i,a,s,r,l,c,u,h=e.getFromEnv("dataSource"),d=h.chart||{},p=e.config,g=h.dataset,f=e.getChildren().canvas[0].getChildren("vCanvas")[0];p.cdm=t=(0,n.pluckNumber)(d.compactdatamode,0),p.cdmchar=i=(0,n.pluck)(d.dataseparator,o),g||e.setChartMessage();for(s=0;s<g.length;s++)if(a=g[s],t&&a.data&&a.data.split){for(c=a.data.split(i),r=[],l=0,u=c.length;l<u;l++)r.push({value:c[l]});a.data=r}(0,n.datasetFactory)(f,e.getDSdef(),"dataset",g.length,g),e.iterateComponents((function(e){e.getType&&"dataset"===e.getType()&&e.createPinElem&&e.addEventListener("createpinelements",e.createPinElem)}))};var n=i(184),o="|"},1117:function(e,t,i){"use strict";var n=i(178);t.__esModule=!0,t["default"]=void 0;var o=n(i(1118))["default"];t["default"]=o},1118:function(e,t,i){"use strict";var n=i(178);t.__esModule=!0,t["default"]=void 0;var o=n(i(198)),a=n(i(1112)),s=i(545),r=n(i(546)),l=n(i(1119)),c=function(e){function t(){var t;return(t=e.call(this)||this).getSpecificxAxisConf=s.getSpecificxAxisConf,t.getSpecificyAxisConf=s.getSpecificyAxisConf,t.registerFactory("axis",r["default"],["canvas"]),t.registerFactory("dataset",l["default"],["vCanvas"]),t}(0,o["default"])(t,e),t.getName=function(){return"ZoomLineDy"};var i=t.prototype;return i.getName=function(){return"ZoomLineDy"},i.__setDefaultConfig=function(){e.prototype.__setDefaultConfig.call(this);var t=this.config;t.friendlyName="Zoomable and Panable Multi-series Dual-axis Line Chart",t.defaultDatasetType="zoomline",t.isdual=!0,t.syncaxislimits=0},i._feedAxesRawData=function(){return s._feedAxesRawData.call(this)},t}(a["default"]);c.prototype.setAxisDimention=s.setAxisDimention;var u=c;t["default"]=u},1119:function(e,t,i){"use strict";t.__esModule=!0,t["default"]=function(e){var t,i,s,r,l,c,u,h,d,p=e.getFromEnv("dataSource"),g=p.chart||{},f=e.config,m=p.dataset,v=e.getChildren().canvas[0],b=[],x=[],C=[],y=[],k=v.getChildren("vCanvas");f.cdm=t=(0,n.pluckNumber)(g.compactdatamode,0),f.cdmchar=i=(0,n.pluck)(g.dataseparator,o),m||e.setChartMessage();for(r=0;r<m.length;r++)if(s=m[r],t&&s.data&&s.data.split){for(u=s.data.split(i),l=[],c=0,h=u.length;c<h;c++)l.push({value:u[c]});s.data=l}for(r=0;r<m.length;r++)d=m[r],"s"===(d.parentyaxis||"").toLowerCase()?(y.push(d),x.push(r)):(C.push(d),b.push(r));C.length?(0,n.datasetFactory)(k[0],e.getDSdef(),"dataset_line",C.length,C,b):a(k[0]);y.length?(0,n.datasetFactory)(k[1],e.getDSdef(),"dataset_line",y.length,y,x):a(k[1]);e.iterateComponents((function(e){e.getType&&"dataset"===e.getType()&&e.createPinElem&&e.addEventListener("createpinelements",e.createPinElem)}))};var n=i(184),o="|",a=function(e){e&&e.iterateComponents((function(e){"dataset"===e.getType()&&e.remove()}))}},1120:function(e,t,i){"use strict";var n=i(178);t.__esModule=!0,t["default"]=void 0;var o,a,s,r,l=n(i(201)),c=n(i(198)),u=i(184),h=i(199),d=Math,p=d.max,g=d.min,f=0,m="ontouchstart"in window,v={zoomlinedy:!0,zoomline:!0},b=function(){this.remove()},x=function(){this.remove()},C=function(e,t,i){return i.getFromEnv("animationManager").setAnimation({el:"group",attr:{name:e},container:t,state:"appearing",component:i,label:"group"})},y=function(e){var t,i,n,o={},s=Number.POSITIVE_INFINITY;for(t=0;t<this.length;t++)n=(i=this[t]-e)<0?a.NEG:a.POS,(i=Math.abs(i))<=s&&(s=i,o.absValue=i,o.noScaleSide=n);return o},k=function(e){return{onMouseOut:function(){e.hide(),e.position=o},onMouseMove:function(t){var i,n,o,a,s,r,l,c,h,d,p,g;e.disabled||e._mouseIsDown&&!m||(n=e.getZoomInfo(),o=e.getGraphicalElement("line"),a=n.step,r=(s=e.chart).getChildren("xAxis")[0],c=(l=s.get("config")).canvasLeft,h=(0,u.getMouseCoordinate)(e.getFromEnv("chart-container"),t,s).chartX,d=r.getVisibleConfig(),p=r.getAxisConfig("axisDimention").x-c,g=(g=e.getDataIndexFromPixel(Math.round(h)))+((i=g%a)>a/2?a-i:-i),h=r.getPixel(g,{wrtVisible:!0})-p-c,h-=n.offset,o.transform(["T",Math.round(h),0]),e.hidden&&0!==l.crossline.enabled&&e.show(),(g<d.minValue||g>d.maxValue)&&e.hide(),(g!==e.position||e.hidden)&&(e.position=g,e.lineX=h,e.updateLabels()))}}},w=function(e){function t(){var t;return(t=e.call(this)||this).config.handlers=k((0,l["default"])(t)),t}(0,c["default"])(t,e);var i=t.prototype;return i.configureAttributes=function(e){this.config.options=e},i.draw=function(){var e,t,i,n,o,a,s,r,l={},c=this.getFromEnv("chart"),h=c.getFromEnv()["number-formatter"],d=c.config,p=this.left=c.getChildren("xAxis")[0].getAxisConfig("axisDimention").x,g=this.top=d.canvasTop,f=this.height=d.canvasHeight,m=this._visout=d._visout,v=[],y=this.getFromEnv("animationManager"),k=this.getGraphicalElement("line"),w=this.config.options,E=w.labelstyle,M=w.valuestyle,P=c.getChildren("yAxis")[0],L=P.getLimit(),_=c.getChildren("yAxis")[1],T=_&&_.getLimit(),N=this.getGraphicalElement("labels"),F=[],S=this.getGraphicalElement("positionLabel"),D=this.getLinkedParent().getChildContainer("crosslineBottom"),A=this.getLinkedParent().getChildContainer("crosslineTop");if(c.iterateComponents((function(e){e.getType&&"dataset"===e.getType()&&!e.getState("removed")&&v.push(e)})),this.plots=v,this.width=d._visw,o=this.group,(o=this.getContainer("valueGroup"))||(o=this.addContainer("valueGroup",C("crossline-value-group",A,this))),(r=this.getContainer("labelGroup"))||(r=this.addContainer("labelGroup",C("crossline-label-group",A,this))).insertBefore(c.getChildContainer("plotGroup")),this.container=D,o.attr({transform:["T",p,d._ymin]}).css(M),a=y.setAnimation({el:k||"path",container:D,doNotRemove:!0,attr:(0,u.extend2)({path:["M",p,g,"l",0,f]},w.line)}).toBack(),k||this.addGraphicalElement("line",a,!1),w.labelEnabled&&(l.x=m,l.y=g+f+(d.scrollHeight||0)+2.5,l["vertical-align"]="top",l.direction=d.textDirection,l.text=""),s=y.setAnimation({el:S||"text",attr:w.labelEnabled&&l,css:w.labelEnabled&&E,container:r,doNotRemove:!0,callback:!w.labelEnabled&&b}),!S&&w.labelEnabled&&this.addGraphicalElement("positionLabel",s,!1),this.hide(),this.ppixelRatio=-P.config.axisDimention.axisLength/P.getVisibleLength(),this.spixelRatio=_&&-_.config.axisDimention.axisLength/_.getVisibleLength(),this.yminValue=d._yminValue,this.pyaxisminvalue=L.min,this.pyaxismaxvalue=L.max,this.syaxisminvalue=T&&T.min,this.syaxismaxvalue=T&&T.max,this.positionLabels=d.xlabels||{data:[],parsed:[]},this.chart=c,e=0,w.valueEnabled){for(t=v.length;e<t;e+=1)i=v[e],n=(0,u.hashify)(i.config.linecolor),l.x=0,l.y=m,l.fill=n,l.direction=d.textDirection,l.text="",l["text-bound"]=M["text-bound"],l.lineHeight=M.lineHeight,F[e]=y.setAnimation({el:N&&N[e]||"text",container:o,doNotRemove:!0,attr:l}),(!N||!N[e])&&this.addGraphicalElement("labels",F[e],!0);this.numberFormatter=h}for(t=N&&N.length;e<t;e++)y.setAnimation({el:N[e],component:this,doNotRemove:!0,callback:x});N&&N.splice(v.length)},i.getType=function(){return"crossline"},i.getName=function(){return"crossLine"},i.getZoomInfo=function(){return this.getFromEnv("chartConfig").viewPortConfig},i.getDataIndexFromPixel=function(e){return Math.round(this.getFromEnv("chart").getChildren("xAxis")[0].getValue(e,{wrtVisible:!0}))},i.getPositionLabel=function(e){var t=this.getFromEnv("chart").getChildren("xAxis")[0].getLabel(e);return t&&t.label||""},i.disable=function(e){return e!==o&&(this.disabled=!!e,this.disabled&&this.visible&&this.hide()),this.disabled},i.updateLabels=function(){var e=this,t=e.getFromEnv("animationManager"),i=e.getGraphicalElement("labels"),n=e.getGraphicalElement("positionLabel"),l=e.plots,c=e.width,u=e.position,h=e.lineX,d=Math.floor(h),m=e.dummyText,v=e.numberFormatter,b=e.pyaxisminvalue,x=e.pyaxismaxvalue,C=e.syaxisminvalue,y=e.syaxismaxvalue,k=function(e){var t,i,n=e.getFromEnv("chart").getChildren("yAxis")[0].getPixel(e.yminValue),o={};a={},s=-1*e.height;try{Object.defineProperty(a,"POS",{enumerable:!1,configurable:!1,get:function(){return 1}}),Object.defineProperty(a,"NEG",{enumerable:!1,configurable:!1,get:function(){return-1}})}catch(r){a.POS=1,a.NEG=-1}try{Object.defineProperty(o,"top",{enumerable:!1,configurable:!1,get:function(){return s}}),Object.defineProperty(o,"bottom",{enumerable:!1,configurable:!1,get:function(){return n}})}catch(r){o.top=s,o.bottom=n}return o.init=function(e){var n;for(s+=(f=e+2)/2,i=Math.floor(Math.abs(s)/f),t=new M(i),n=0;n<i;n++)t.pos.push(0)},o.occupy=function(e,i){var n=Math.floor(Math.abs(s-e)/f);t&&t.attachShift(e,n,i)},o}(e);r=e._visout,i&&(m||(m=e.dummyText=e.getFromEnv("paper").text().hide()),m.attr({text:v.yAxis("0")}),m&&k.init(m.getBBox().height,i.length),i.forEach((function(t,i){if(!l[i].getState("removed")){var n,a=l[i],s=a.components.data[u]&&a.components.data[u].config.setValue,c=a.config.parentYAxis;n=s===o||!a.getState("visible")||(c?s>y||s<C:s>x||s<b)?r:c?(s-C)*e.spixelRatio:(s-b)*e.ppixelRatio,k.occupy(n,t)}}))),i&&i.forEach((function(i,n){if(!l[n].getState("removed")){var a,s,r,f,m,b,x=l[n],C=x.components.data[u]&&x.components.data[u].config.setValue,y=v[x.config.parentYAxis?"sYAxis":"yAxis"](C);y?(i.attr({text:y}),f=(r=(s=(a=i.getBBox())&&a.width)&&.5*s)&&r+10,b=i.calcY,m=p(0,g(d,c)),b!==o&&m!==o&&t.setAnimation({el:i,attr:{x:m,y:b,"text-anchor":(h<=f?"start":h+f>=c&&"end")||"middle","text-bound":["rgba(255,255,255,0.8)","rgba(0,0,0,0.2)",1,2.5]},doNotRemove:!0,component:e})):i.attr({x:-c})}})),n&&t.setAnimation({el:n,attr:{x:h+e.left,text:e.getPositionLabel(u),"text-bound":["rgba(255,255,255,1)","rgba(0,0,0,1)",1,2.5]},component:e})},i.show=function(){if(!this.disabled){this.hidden=!1;var e=this.getContainer("valueGroup"),t=this.getGraphicalElement("positionLabel"),i=this.getGraphicalElement("line");e&&e.show(),t&&t.show(),i&&i.show()}},i.hide=function(){this.hidden=!0;var e=this.getContainer("valueGroup"),t=this.getGraphicalElement("positionLabel"),i=this.getGraphicalElement("line");e&&e.hide(),t&&t.hide(),i&&i.hide()},i.dispose=function(){var e;for(e in this)this.hasOwnProperty(e)&&delete this[e]},t}(h.ComponentInterface);var E=function(){function e(){this.y=0,this.lRef=o,this.__shift=0,this.__index=0}var t=e.prototype;return t.applyShift=function(e){this.__shift=e,this.lRef.calcY=this.y+=e*f},t.applyDirectIndex=function(e){this.__index=e,this.lRef.calcY=this.y=s-e*f*-1},e}(),M=function(){function e(e){this.holes=[],this.pos=[];for(var t=0;t<e;t++)this.holes.push(t)}var t=e.prototype;return t.repositionHoles=function(){var e,t=0,i=this.pos;for(this.holes.length=0,e=0;e<i.length;e++)!i[e]&&(this.holes[t++]=e)},t.attachShift=function(e,t,i){var n,o,s,l,c,u,h,d=this.pos,p=d.length;if(e!==r){if(n=d[u=t>p-1?p-1:t],(l=new E).y=e,l.lRef=i,!n)return l.applyDirectIndex(u),d.splice(u,1,l),void this.holes.splice(this.holes.indexOf(u),1);if(o=u+(h=y.call(this.holes,u)).absValue*h.noScaleSide,h.noScaleSide===a.POS)return l.applyDirectIndex(o),d.splice(o,1,l),this.holes.splice(this.holes.indexOf(o),1),o;if(h.noScaleSide===a.NEG){for(s=d.splice(o+1,d.length-1),d.pop(),s.forEach((function(e){e&&e.applyShift(-1)})),[].push.apply(d,s),c=o;d[c];)c++;return d.push(0),this.repositionHoles(),c+=(h=y.call(this.holes,c)).absValue*h.noScaleSide,l.applyDirectIndex(c),d.splice(c,1,l),this.repositionHoles(),d.length-1}}else i.calcY=r},e}(),P={extension:function(e){e.addEventListener("instantiated",(function(e){if("canvas"===e.sender.getName()){var t,i,n,o=e.sender;o.registerFactory("crossLineManager-zoomline",(function(){var a,s=e.sender.getFromEnv("chart"),r=s&&s.getName();r&&v[r.toLowerCase()]&&((i=s.config.crossline)&&0!==i.enabled&&1===s.config.useCrossline?n=1:(i&&(i.enabled=0),n=0),(0,u.componentFactory)(o,w,"crossLine",n,[i]),n&&(a=o.getChildren("crossLine")[0],t=a.config.handlers,a.addExtEventListener("fc-mousemove",t.onMouseMove,o),a.addExtEventListener("fc-mouseover",t.onMouseMove,o),a.addExtEventListener("fc-dragstart",(function(e){t.onMouseOut(e),a.removeExtEventListener("fc-mousemove",t.onMouseMove,o)}),o),a.addExtEventListener("fc-dragend",(function(){a.addExtEventListener("fc-mousemove",t.onMouseMove,o)}),o),a.addExtEventListener("fc-mouseout",(function(e){t.onMouseOut(e)}),o)))}))}}))},name:"crossline-manager",type:"extension",requiresFusionCharts:!0};t["default"]=P}}])}));
//# sourceMappingURL=http://localhost:3052/3.15.0-rc.1/map/eval/fusioncharts.zoomline.js.map