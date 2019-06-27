!function(t){"object"==typeof module&&"undefined"!=typeof module.exports?module.exports=t:t()}(function(){(window.webpackJsonpFusionCharts=window.webpackJsonpFusionCharts||[]).push([[9],{1051:function(t,e,o){"use strict";e.__esModule=!0,e.ZoomScatter=undefined;var i,n=o(1052),a=(i=n)&&i.__esModule?i:{"default":i};e.ZoomScatter=a["default"],e["default"]={name:"zoomscatter",type:"package",requiresFusionCharts:!0,extension:function(t){t.addDep(a["default"])}}},1052:function(t,e,o){"use strict";e.__esModule=!0;var i,n=o(1053),a=(i=n)&&i.__esModule?i:{"default":i};e["default"]=a["default"]},1053:function(t,e,o){"use strict";e.__esModule=!0;var i=c(o(534)),n=c(o(1054)),a=o(126),r=o(1022),s=o(133),l=o(137);function c(t){return t&&t.__esModule?t:{"default":t}}function h(t,e){if("function"!=typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function, not "+typeof e);t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,enumerable:!1,writable:!0,configurable:!0}}),e&&(Object.setPrototypeOf?Object.setPrototypeOf(t,e):function(t,e){for(var o=Object.getOwnPropertyNames(e),i=0;i<o.length;i++){var n=o[i],a=Object.getOwnPropertyDescriptor(e,n);a&&a.configurable&&t[n]===undefined&&Object.defineProperty(t,n,a)}}(t,e))}(0,s.getDep)("redraphael","plugin").addSymbol(r.symbolList);var g=function(t){function e(){!function(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}(this,e);var o=function(t,e){if(!t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!e||"object"!=typeof e&&"function"!=typeof e?t:e}(this,t.call(this));return o.highlightEnabled=!1,o.isXY=!0,o.zoom=!0,o.zoomX=!0,o.zoomY=!0,o.defaultZeroPlaneHighlighted=!1,o}return h(e,t),e.getName=function(){return"ZoomScatter"},e.prototype.getName=function(){return"ZoomScatter"},e.prototype.__setDefaultConfig=function(){t.prototype.__setDefaultConfig.call(this);var e=this.config;e.friendlyName="ZoomScatter Chart",e.defaultDatasetType="zoomscatter",e.enablemousetracking=!0,e.animation=0},e.prototype.configureAttributes=function(e){var o,i=this.config;t.prototype.configureAttributes.call(this,e),o=this.getFromEnv("dataSource").chart,i.stepZoom=400/(100-(0,a.pluckNumber)(o.stepzoom,25)),i.stepZoom<=2&&(i.stepZoom=1.9),i.showToolBarButtonTooltext=(0,a.pluckNumber)(o.showtoolbarbuttontooltext,1),i.btnResetChartToolText=i.showToolBarButtonTooltext?(0,a.pluck)(o.btnresetcharttooltext,"Reset Chart"):"",i.btnZoomOutToolText=i.showToolBarButtonTooltext?(0,a.pluck)(o.btnzoomouttooltext,"Zoom out to previous level"):"",i.btnZoomInToolText=i.showToolBarButtonTooltext?(0,a.pluck)(o.btnzoomintooltext,"<strong>Zoom in</strong><br/>Or double-click on plot to zoom-in"):"",i.btnSelectZoomToolText=i.showToolBarButtonTooltext?(0,a.pluck)(o.btnselectzoomtooltext,"<strong>Select a region to zoom-in</strong><br/>Click to enable pan mode."):"",i.btnPanToolText=i.showToolBarButtonTooltext?(0,a.pluck)(o.btnpantooltext,"<strong>Drag to move across chart</strong><br/>Click to enable select-zoom mode."):""},e.includeInputOptions=function(){return["DragPan","DragZoomIn","ZoomResetButton","ZoomOutButton","ZoomInButton","DbTapZoom","PinchZoom"]},e.prototype.getInputConfigurations=function(){var t=this,e=t.config,o=function(){t.addJob("spaceManage",function(){t._manageInteractiveSpace()},l.priorityList.configure)};return{dragZoomIn:{scaleX:!0,scaleY:!0,boxStyle:{"stroke-width":1,stroke:"red",fill:"#00FF00",opacity:.2,cursor:"ne-resize"},dragendFn:o,tooltext:e.btnSelectZoomToolText,zoomDecimalLimit:2},zoomResetButton:{tooltext:e.btnResetChartToolText,hookFn:o},zoomOutButton:{tooltext:e.btnZoomOutToolText,hookFn:o},zoomInButton:{tooltext:e.btnZoomInToolText,stepzoom:e.stepZoom,zoomDecimalLimit:2,hookFn:o},dragPan:{tooltext:e.btnPanToolText},dbTapZoom:{stepzoom:e.stepZoom,zoomDecimalLimit:2,hookFn:o},pinchZoom:{zoomDecimalLimit:2}}},e.prototype._checkInvalidSpecificData=function(){if(!this.getFromEnv("dataSource").dataset)return!0},e.prototype.getDatasets=function(){var t=[];return this.iterateComponents(function(e){e.getType&&"dataset"===e.getType()&&t.push(e)}),t},e.prototype.getDSdef=function(){return n["default"]},e.prototype.getDSGroupdef=function(){},e}(i["default"]);g.prototype._manageInteractiveSpace=a._manageInteractiveSpace,e["default"]=g},1054:function(t,e,o){"use strict";e.__esModule=!0;var i=l(o(538)),n=l(o(539)),a=o(137),r=o(126),s=l(o(243));function l(t){return t&&t.__esModule?t:{"default":t}}function c(t,e){if("function"!=typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function, not "+typeof e);t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,enumerable:!1,writable:!0,configurable:!0}}),e&&(Object.setPrototypeOf?Object.setPrototypeOf(t,e):function(t,e){for(var o=Object.getOwnPropertyNames(e),i=0;i<o.length;i++){var n=o[i],a=Object.getOwnPropertyDescriptor(e,n);a&&a.configurable&&t[n]===undefined&&Object.defineProperty(t,n,a)}}(t,e))}var h=window,g=function(){this.hide()},d=Math.PI,u=r.preDefStr.DEFAULT,p=2*d,f=function(t,e){return t*e>=0},m=function(t,e,o,i,n,a,r,s){var l,c,h,g,d,u,p,m,x,y;return y=(l=i-e)*r+(h=t-o)*s+(d=o*e-t*i),0!==(x=l*n+h*a+d)&&0!==y&&f(x,y)?0:(m=(c=s-a)*o+(g=n-r)*i+(u=r*a-n*s),0!==(p=c*t+g*e+u)&&0!==m&&f(p,m)?0:(l*g-c*h,1))},x=function(t,e,o){if(!(isNaN(t.x)||isNaN(t.y)||isNaN(e.x)||isNaN(e.y)))return m(t.x,t.y,e.x,e.y,o.xMinWPad,o.yMaxWPad,o.xMaxWPad,o.yMaxWPad)||m(t.x,t.y,e.x,e.y,o.xMaxWPad,o.yMaxWPad,o.xMaxWPad,o.yMinWPad)||m(t.x,t.y,e.x,e.y,o.xMaxWPad,o.yMinWPad,o.xMinWPad,o.yMinWPad)},y=function(t){var e=(t.config.axisRange.max-t.config.axisRange.min)/(t.getVisibleConfig().maxValue-t.getVisibleConfig().minValue);return e=Math.round(1e3*e)/1e3},v=function(t){return[t-1,t,t+1]},b=function(t,e,o){return t>=e&&t<=o},P=function(t,e,o){return b(t,e,o)||b(t,o,e)},w=function(t,e){return(e=parseFloat(e/100))<0?e=0:e>1&&(e=1),t||(t="#FFFFFF"),r.isIE&&!r.hasSVG?e?t:"transparent":(t=t.replace(/^#?([a-f0-9]+)/gi,"$1"),(t=(0,r.HEXtoRGB)(t))[3]=e.toString(),"rgba("+t.join(",")+")")},T=function(t){var e,o,i=[],n=t.getVisibleConfig(),a=n.maxValue-n.minValue,r=n.minValue+a/2,s=t.config,l=s.axisRange;return e=Math.abs((r-(s.isReverse?l.max:l.min))/a),o=i.focusedGrid=Math.floor(e),i.push(o),e%1>.5?i.push(o+1):e%1<.5&&i.unshift(o-1),i},S=function(t){function e(){return function(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}(this,e),function(t,e){if(!t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!e||"object"!=typeof e&&"function"!=typeof e?t:e}(this,t.apply(this,arguments))}return c(e,t),e.prototype.getType=function(){return"dataset"},e.prototype.getName=function(){return"zoomScatter"},e.prototype.configureAttributes=function(e){t.prototype.configureAttributes.call(this,e);var o,i,n,a,s,l,c,h=this.config,g=this.getFromEnv("chart"),d=g.config,u=g.getFromEnv("dataSource").chart,p=(0,r.pluck)(e.anchorbordercolor,u.anchorbordercolor),f=(0,r.getFirstColor)((0,r.pluck)(p,h.plotBorderColor)),m=(0,r.pluckNumber)(e.anchorborderthickness,u.anchorborderthickness,p?1:0),x=(0,r.getFirstColor)((0,r.pluck)(e.anchorbgcolor,e.color,u.anchorbgcolor,h.plotColor)),y=(0,r.pluck)(e.anchoralpha,e.alpha,u.anchoralpha,r.HUNDREDSTRING),v=(0,r.pluck)(e.anchorbgalpha,e.alpha,u.anchorbgalpha,r.HUNDREDSTRING),b={color:h.lineColor,alpha:h.lineAlpha};h.plotCosmetics={fillStyle:w(x,y*v/100),strokeStyle:w(f,y),borderWidth:m,lineWidth:h.lineThickness,lineStrokeStyle:(0,r.toRaphaelColor)(b)},this.config.JSONData=e,h.anchorBorderThickness=(0,r.pluckNumber)(e.anchorborderthickness,u.anchorborderthickness,p?1:0),h.chunkSize=Math.floor(Math.min((e.data||[]).length/5,5e4)),c=h.staticRadius=(0,r.pluckNumber)(u.staticradius,0),h.radius=(0,r.pluckNumber)(e.radius,e.anchorradius,u.radius,u.anchorradius,c?3:.5),l=h.showHoverEffect,o=(0,r.getFirstColor)((0,r.pluck)(e.plotfillhovercolor,e.hovercolor,u.plotfillhovercolor,u.hovercolor,h.anchorbgcolor)),i=(0,r.pluck)(e.plotfillhoveralpha,e.hoveralpha,u.plotfillhoveralpha,u.hoveralpha,r.HUNDREDSTRING),n=(0,r.getFirstColor)((0,r.pluck)(e.plotfillhovercolor,e.hovercolor,u.plotfillhovercolor,u.hovercolor,o)),s=(0,r.pluck)(e.plotfillhoveralpha,e.hoveralpha,u.plotfillhoveralpha,u.hoveralpha,r.HUNDREDSTRING),a=(0,r.pluckNumber)(e.borderhoverthickness,u.borderhoverthickness,1),h.hoverCosmetics={showHoverEffect:l,fill:w(o,i),borderColor:w(n,s),borderThickness:a},h.tooltip={toolTipVisible:d.showtooltip,seriesNameInToolTip:d.seriesnameintooltip,toolTipSepChar:d.tooltipsepchar},h.lastViewPort={},this.disableScrollBars(),this.setState("dirty",!0)},e.prototype.hasDrawingRefChanged=function(){var t,e=this.getFromEnv("xAxis"),o=this.getFromEnv("yAxis"),i=this.config,n=i.axisConfig=i.axisConfig||{},a=y(e),r=this.getFromEnv("chartConfig"),s=y(o);return t=n.xZoomScale!==a||n.yZoomScale!==s||i.prevCanvasHeight!==r.canvasHeight||i.prevCanvasWidth!==r.canvasWidth,n.xZoomScale=a,n.yZoomScale=s,i.prevCanvasHeight=r.canvasHeight,i.prevCanvasWidth=r.canvasWidth,t},e.prototype.saveScrollPos=function(){var t=this.getFromEnv("xAxis"),e=this.getFromEnv("yAxis"),o=this.config,i=o.axisConfig=o.axisConfig||{};i.xScrollPos=t.config.apparentScrollPos,i.yScrollPos=e.config.apparentScrollPos},e.prototype.disableScrollBars=function(){var t=this.getFromEnv("xAxis"),e=this.getFromEnv("yAxis");t.setScrollType("none"),e.setScrollType("none")},e.prototype.calculateZoomedRadius=function(){var t=this.config,e=this.getFromEnv("chart").config,o=t.axisConfig;t.zoomedRadius=Math.min(t.staticRadius?t.radius:t.radius*Math.min(o.xZoomScale,o.yZoomScale),e.canvasWidth/2,e.canvasHeight/2)},e.prototype.setupKdTree=function(){var t,e,o,i=this,r=i.components.data,s=r.length,l=[];for(e=0;e<s;++e)o=(t=r[e]).config.setValue,isNaN(o.x)||isNaN(o.y)||(o.index=e,l.push({x:o.x,y:o.y,index:e,data:t,r:1}));i.addJob("kdtree",function(){i.dataTree=(new n["default"]).buildKdTree(l)},a.priorityList.kdTree)},e.prototype._getHoveredPlot=function(t,e){var o,i,n,a=this.getFromEnv("xAxis"),r=this.getFromEnv("yAxis");if(i=a.getValue(t+a.getTranslation()),n=r.getValue(e+r.getTranslation()),o=this.dataTree&&this.dataTree.getNeighbour({x:i,y:n,options:this.zoomRadiusOb},!0))return o.data.x=o.x,o.data.y=o.y,{pointIndex:o.index||o.i,hovered:!0,pointObj:o.data}},e.prototype._decideTooltipType=function(t,e){var o=this.getFromEnv("toolTipController"),i=this.config.currentToolTip,n=this.components.data[t],a=n&&(n.config.finalTooltext||n.config.toolText),r=e.originalEvent;a&&(i?o.draw(r,a,i):i=this.config.currentToolTip=o.draw(r,a))},e.prototype._firePlotEvent=function(t,e,o){var i,n=this.getFromEnv("chart"),a=this.components,r=this.getFromEnv("toolTipController"),s=a.data[e],l=this.getFromEnv("paper").canvas.style;if(s)switch(i=s.config.setLink,t){case"fc-mouseover":this._decideTooltipType(e,o),this.highlightPoint(this.config.showHoverEffect,s),n.plotEventHandler(this.getGraphicalElement("tracker"),o,"dataplotRollover"),i&&(l.cursor="pointer");break;case"fc-mouseout":r.hide(this.config.currentToolTip),i&&(l.cursor=u),this.highlightPoint(!1),n.plotEventHandler(this.getGraphicalElement("tracker"),o,"dataplotRollout");break;case"fc-click":n.plotEventHandler(this.getGraphicalElement("tracker"),o,"dataplotClick");break;case"fc-mousemove":this._decideTooltipType(e,o)}},e.prototype.highlightPoint=function(t,e){var o,i=this.getFromEnv("chart").config,n=this.getFromEnv("animationManager"),a=this.getGraphicalElement("tracker"),r=this.getFromEnv("xAxis"),s=this.getFromEnv("yAxis"),l=this&&this.config,c=l&&l.zoomedRadius||0,h=l&&l.hoverCosmetics,d=h&&h.fill,u=h&&h.borderColor,p=h&&h.borderThickness,f={},m=e&&e.link;t&&(f={r:c,fill:d,stroke:u,"stroke-width":p,cx:r.getPixel(e.x),cy:s.getPixel(e.y)}),n.setAnimationState(t?"mouseover":"mouseout"),o=n.setAnimation({el:a||"circle",attr:t&&f,container:this.getContainer("plotGroup"),component:this,doNotRemove:!0,callback:!t&&g}),t&&o.show(),a||this.addGraphicalElement("tracker",o),e&&o.data("eventArgs",{x:e.x,y:e.y,tooltip:e.config.toolText,link:m}),i.lastHoveredPoint=e,f.cursor=m?"pointer":""},e.prototype.drawCommonElements=function(){},e.prototype.animateCommonElements=function(){},e.prototype.remove=function(){t.prototype.remove.call(this),this._deleteGridImages()},e.prototype.drawPlots=function(){var t,e,o,i,n,a=this.getFromEnv("animationManager"),r=this.getFromEnv("xAxis"),s=this.getFromEnv("yAxis"),l=this.config,c=this.getContainer("plotGroup"),h=this.getContainer("containerLine"),g=this.getContainer("containerPlot"),d=!1,u=this.config.anchorBorderThickness;this.saveScrollPos(),i=a.setAnimation({el:h||"group",attr:{name:"lineGroup"},container:c,component:this,label:"group"}),n=a.setAnimation({el:g||"group",attr:{name:"plotGroup"},container:c,component:this,label:"group"}),this.getState("visible")?(i.show(),n.show()):(i.hide(),n.hide()),!h&&this.addContainer("containerLine",i),!g&&this.addContainer("containerPlot",n),(this.hasDrawingRefChanged()||this.wasLastDrawPixelated||this.getState("dirty"))&&(this.wasLastDrawPixelated=!1,this.calculateZoomedRadius(),t=y(r),e=y(s),o=l.radius*Math.min(t,e),this.zoomRadiusOb={rx:r.getValue(o+u)-r.getValue(0),ry:s.getValue(0)-s.getValue(o+u)},this._deleteGridImages(),this._graphics._grid={},d=!0),this._gridDraw(d),this.setState("dirty",!1)},e.prototype._deleteGridImages=function(){var t,e,o,i,n,a,r,s,l=this.config,c=this._graphics,h=c._imagePool||(c._imagePool=[]),g=c._canvasPool||(c._canvasPool=[]),d=c._lineImagePool||(c._lineImagePool=[]),u=c._lineCanvasPool||(c._lineCanvasPool=[]),p=c._grid||[],f=l._batchDrawTimers;if(f&&f.length)for(;f.length;)this.removeJob(f.shift());for(a in p)if(s=p[a])for(r in s)(n=s[r])&&n.drawState&&((t=n.image).attr({src:"",width:0,height:0}),h.push(t),delete n.image,i=n.canvas,g.push(i),delete n.canvas,delete n.ctx,(e=n.lineImage)&&(e.attr({src:"",width:0,height:0}),d.push(e),delete n.lineImage,o=n.lineCanvas,u.push(o),delete n.lineCanvas,delete n.lineCtx));delete c._grid},e.prototype._gridDraw=function(t){var e=this,o=e.config;clearTimeout(o.timer),t?e._gridManager():o.timer=e.addJob("_gridManagerId",function(){e._gridManager()},a.priorityList.label)},e.prototype.getAllGrids=function(){var t,e,o,i,n,a,r,s,l,c=this.config,h=this.getFromEnv("chart").config,g=this.getFromEnv("xAxis"),d=this.getFromEnv("yAxis"),u=T(g),p=T(d),f=v(u.focusedGrid),m=v(p.focusedGrid),x=[],b=[],P=0,w=0,S=this._graphics._grid,k={},C=y(g),E=y(d),M=Math.ceil(E),_=Math.ceil(C),F=Math.max(p.focusedGrid-1,0),I=Math.min(p.focusedGrid+1,M-1),N=Math.max(u.focusedGrid-1,0),D=Math.min(u.focusedGrid+1,_-1),A=g.getAxisConfig("axisDimention").axisLength||h.canvasWidth,R=d.getAxisConfig("axisDimention").axisLength||h.canvasHeight,V=g.config,L=d.config,G=V.axisRange.min,W=V.axisRange.max,O=L.axisRange.min,B=L.axisRange.max,Z=c.radius*Math.min(C,E)+c.plotCosmetics.borderWidth,z=Math.abs(Z/(A*C/(g.config.axisRange.max-g.config.axisRange.min))),H=Math.abs(Z/(R*E/(d.config.axisRange.max-d.config.axisRange.min))),j=d.getPixel(d.config.axisRange.max),J=g.getPixel(g.config.axisRange.min);for(S||(this.config.grids=S={}),P=F;P<=I;++P)for(S[P]=k=S[P]||{},s=j+P*R,i=d.getValue(s),n=d.getValue(s+R),w=N;w<=D;++w)a=0===w?Z:0,r=w===_-1?Z:0,l=J+w*A-a,o=g.getValue(l),e=g.getValue(l+A+a+r),k[w]=t=k[w]||{xPixel:l,width:Math.abs(g.getPixel(e)-l),yPixel:s,height:d.getPixel(n)-s,xLeftValue:o,yTopValue:i,xRightValue:e,yBottomValue:n,drawState:0,xMinWPad:Math.max(Math.min(o,e)-z,G),yMinWPad:Math.max(Math.min(i,n)-H,O),xMaxWPad:Math.min(Math.max(o,e)+z,W),yMaxWPad:Math.min(Math.max(i,n)+H,B),i:P,j:w},t.drawState||(~u.indexOf(w)&&~p.indexOf(P)?x.push(t):~f.indexOf(w)&&~m.indexOf(P)&&b.push(t));return{focused:x,nearBy:b}},e.prototype.allocatePosition=function(){var t,e,o,i,n,a=this.config,r=this.components.data,s=r.length,l=this.getFromEnv("xAxis"),c=this.getFromEnv("yAxis"),h=a.zoomedRadius;for(o=0;o<s;o++)i=(n=r[o].config).setValue,t=l.getPixel(i.x),e=c.getPixel(i.y),n.props={element:{attr:{polypath:[0,t,e,h||n.anchorProps.radius]}},label:{attr:{}}}},e.prototype._gridManager=function(){var t,e,o=this;t=o.getAllGrids(),o.config._drawGrid=t.focused,(t.focused.length||t.nearBy.length)&&(o.config._drawGrid=t.focused,e=function(){o.config._drawGrid=t.nearBy,o._drawGridArr()},o._drawGridArr(e))},e.prototype._drawGridArr=function(t){var e,o,i,n,a,r,s,l,c,g=this.config,d=g.drawLine,u=g._drawGrid,p=[],f=this.getFromEnv("animationManager"),m=this.getContainer("containerLine"),x=this.getContainer("containerPlot"),v=this.getFromEnv("xAxis"),b=this.getFromEnv("yAxis"),P=y(v),w=y(b),T=this._graphics._imagePool||[],S=this._graphics._canvasPool||[],k=this._graphics._lineImagePool||[],C=this._graphics._lineCanvasPool||[],E=g.plotCosmetics,M=g.radius*Math.min(P,w);if(u.length){for(;u.length;)l=(e=u.shift()).xPixel,c=e.yPixel,r=e.width,s=e.height,2!==e.drawState&&(e.drawState=2,d&&(k.length&&(e.lineImage=k.shift()),e.lineImage=f.setAnimation({el:e.lineImage||"image",attr:{x:l,y:c,width:r,height:s},container:m,component:this,label:"image"}),C.length?e.lineCanvas=i=C.shift():e.lineCanvas=i=h.document.createElement("canvas"),i.setAttribute("width",r),i.setAttribute("height",s),(a=e.lineCtx=i.getContext("2d")).fillStyle=E.fillStyle,a.strokeStyle=E.lineStrokeStyle,a.lineWidth=E.lineWidth),T.length&&(e.image=T.shift()),e.image=f.setAnimation({el:e.image||"image",attr:{x:l,y:c,width:r,height:s},container:x,component:this,label:"image"}),S.length?e.canvas=o=S.shift():e.canvas=o=h.document.createElement("canvas"),o.setAttribute("width",r),o.setAttribute("height",s),n=e.ctx=o.getContext("2d"),M<1?(n.strokeStyle=E.fillStyle,n.lineWidth=.5):(n.fillStyle=E.fillStyle,n.strokeStyle=E.strokeStyle,n.lineWidth=E.borderWidth),p.push(e));g._batchDrawindex=this.config.JSONData.data&&this.config.JSONData.data.length-1||0,this._drawGridArrBatch(p,t,!g.animation.enabled)}else t&&t()},e.prototype._drawGridArrBatch=function(t,e,o){var i,n,s,l,c,h,g,d,u,f,m,y,v,b,w,T,S,k,C,E,M,_,F,I,N=this,D=N.config,A=D.drawLine,R=D.plotCosmetics,V=D._batchDrawindex,L=N.components.data,G=V-D.chunkSize,W=N.getFromEnv("xAxis"),O=N.getFromEnv("yAxis"),B=N.getFromEnv("chart"),Z=N.getFromEnv("animationManager"),z=B.getFromEnv("dataSource"),H=D.JSONData,j=D.zoomedRadius,J=(0,r.pluckNumber)(H.showregressionline,B.config.showregressionline,0),U=D._store||[],K=R.lineWidth||j<1;for(J&&(E=(0,r.toRaphaelColor)((0,r.pluck)(H.regressionlinecolor,z.chart.regressionlinecolor,D.anchorbordercolor,D.lineColor,"fff000")),M=(0,r.pluckNumber)(H.regressionlinethickness,z.chart.regressionlinethickness,1),_=(0,r.pluckNumber)(H.regressionlinealpha,z.chart.regressionlinealpha,100)/100),d=0;d<t.length;d+=1)t[d].ctx.beginPath(),A&&t[d].lineCtx.beginPath();for(G=G<=0?0:G;V>=G;V-=1)if((y=L[V]&&L[V].config.setValue)&&!isNaN(y.x)&&!isNaN(y.y))for(d=0;d<t.length;d+=1)u=t[d],P(y.x,u.xMinWPad,u.xMaxWPad)&&P(y.y,u.yMinWPad,u.yMaxWPad)?(f=u.ctx,m=u.lineCtx,i=W.getPixel(y.x)-u.xPixel,n=O.getPixel(y.y)-u.yPixel,(g=U[i])||(g=U[i]={}),g[n]||(g[n]=!0,A&&(v=V&&L[V-1].config.setValue,b=V<L.length-1&&L[V+1].config.setValue,!v||isNaN(v.x)||isNaN(v.y)||(F=W.getPixel(v.x)-u.xPixel,I=O.getPixel(v.y)-u.yPixel,m.moveTo(Math.round(F),Math.round(I)),m.lineTo(i,n),P(b.x,u.xMinWPad,u.xMaxWPad)&&P(b.y,u.yMinWPad,u.yMaxWPad)||isNaN(b.x)||isNaN(b.y)||m.lineTo(W.getPixel(b.x)-u.xPixel,O.getPixel(b.y)-u.yPixel))),j<1?(f.moveTo(i,n),f.lineTo(i+1,n)):(f.moveTo(i+j,n),f.arc(i,n,j,0,p)))):A&&V&&x(y,L[V-1].config.setValue,u)&&(v=L[V-1].config.setValue,F=W.getPixel(v.x)-u.xPixel,I=O.getPixel(v.y)-u.yPixel,i=W.getPixel(y.x)-u.xPixel,n=O.getPixel(y.y)-u.yPixel,(m=u.lineCtx).moveTo(Math.round(F),Math.round(I)),m.lineTo(i,n));for(d=0;d<t.length;d+=1)(f=(u=t[d]).ctx).fill(),K&&f.stroke(),f.closePath(),A&&(m=u.lineCtx,K&&m.stroke(),m.closePath());if(D._batchDrawindex=V,V>=0){if(!o)for(d=0;d<t.length;d+=1)S=t[d].image,k=t[d].canvas,Z.setAnimation({el:S,attr:{src:k.toDataURL("image/png")},component:N}),D.drawLine&&(w=t[d].lineImage,T=t[d].lineCanvas,Z.setAnimation({el:w,src:k.toDataURL("image/png"),component:N}));(D._batchDrawTimers||(D._batchDrawTimers=[])).push(N.addJob("_drawGridArrBatchID",function(){N.getFromEnv("chart")&&N._drawGridArrBatch(t,e,o)},a.priorityList.draw))}else{if(N.setupKdTree(),delete D._store,J)for(C=D.regressionPoints,d=0;d<t.length;d+=1)S=(u=t[d]).image,k=u.canvas,f=u.ctx,C.length&&(s=W.getPixel(C[0].x)-u.xPixel,c=O.getPixel(C[0].y)-u.yPixel,l=W.getPixel(C[1].x)-u.xPixel,h=O.getPixel(C[1].y)-u.yPixel,f.beginPath(),f.strokeStyle=E,f.lineWidth=M,f.globalAlpha=_,f.moveTo(s,c),f.lineTo(l,h),f.stroke(),f.closePath());for(d=0;d<t.length;d+=1)S=(u=t[d]).image,k=u.canvas,u.drawState=1,Z.setAnimation({el:S,attr:{src:k.toDataURL("image/png")},component:N}),A&&(w=u.lineImage,T=u.lineCanvas,Z.setAnimation({el:w,attr:{src:T.toDataURL("image/png")},component:N}));e&&e()}},e.prototype.getRegressionPoints=function(){var t,e,o=this.config.regressionPoints,i=-Infinity,n=Infinity,a=-Infinity,r=Infinity;if(o&&o.length){for(e=o.length,t=0;t<e;t++)i=Math.max(i,o[t].x),n=Math.min(n,o[t].x),a=Math.max(a,o[t].y),r=Math.min(r,o[t].y);return{max:a,min:r,xMax:i,xMin:n}}},e.prototype.show=function(){var t=this.getContainer("containerLine"),e=this.getContainer("containerPlot"),o=this.getFromEnv("legend");o&&o.getItem(this.config.legendItemId)&&o.getItem(this.config.legendItemId).removeLegendState("hidden"),this.setState("visible",!0),t.show(),e.show(),this.setState("dirty",!0)},e.prototype.setContainerVisibility=function(){},e.prototype.draw=function(){var t=this,e=t.config,o=t.getFromEnv("xAxis"),i=o.getPixel(0),n=o.getPixel(1),r=t.getFromEnv("groupMaxWidth"),s=e.drawn,l=(t.getSkippingInfo&&t.getSkippingInfo()||{}).skippingApplied;r||(r=Math.abs(n-i),t.addToEnv("groupMaxWidth",r)),!s&&t.createContainer(),t.setContainerVisibility(!0),l&&t.hidePlots(),t.drawPlots(),t.drawCommonElements&&!t.config.skipCommonElements&&t.drawCommonElements(),e.drawn?t.drawLabel(void 0,void 0):t.addJob("labelDrawID",function(){t.drawLabel(void 0,void 0)},a.priorityList.label),e.drawn=!0,t.removePlots()},e.prototype.hide=function(){var t=this.getContainer("containerLine"),e=this.getContainer("containerPlot"),o=this.getFromEnv("legend");o&&o.getItem(this.config.legendItemId)&&o.getItem(this.config.legendItemId).setLegendState("hidden"),t.hide(),e.hide(),this.setState("dirty",!0),this.setState("visible",!1)},e.prototype._addLegend=function(){var t,e,o=this.getFromEnv("chart"),i=o.getFromEnv("dataSource").chart,n=o.getFromEnv("legend"),a=this.config,s=this.config.JSONData,l=(0,r.pluck)(s.anchorbordercolor,i.anchorbordercolor),c=(0,r.getFirstColor)((0,r.pluck)(l,a.plotBorderColor)),h=(0,r.getFirstColor)((0,r.pluck)(s.anchorbgcolor,s.color,i.anchorbgcolor,a.plotColor)),g=(0,r.pluck)(s.anchoralpha,s.alpha,i.anchoralpha,r.HUNDREDSTRING),d=(0,r.pluck)(s.anchorbgalpha,s.alpha,i.anchorbgalpha,r.HUNDREDSTRING),u=w(h,g*d/100),p=w(c,g);e={enabled:a.includeInLegend,type:this.type,anchorSide:2,label:(0,r.getFirstValue)(this.config.JSONData.seriesname)},a.includeinlegend?((t=n.getItem(this.config.legendItemId))?t.configure({style:n.config.itemStyle,hiddenStyle:n.config.itemHiddenStyle,datasetVisible:n.config.datasetVisible,hoverStyle:n.config.itemHoverStyle}):(this.config.legendItemId=n.createItem(this),t=n.getItem(this.config.legendItemId),this.addExtEventListener("fc-click",function(){t.itemClickFn()},t)),t.configure(e),t.setStateCosmetics("default",{symbol:{fill:u,stroke:p,rawFillColor:h,rawStrokeColor:a.anchorbordercolor,"stroke-width":a.anchorBorderThickness}}),this.getState("visible")?t.removeLegendState("hidden"):t.setLegendState("hidden")):this.config.legendItemId&&n.disposeItem(this.config.legendItemId)},e.prototype._setConfigure=function(){var t,e,o,i,n,a,l,c,h,g,d,u,p=-Infinity,f=+Infinity,m=p,x=f,y=f,v=p,b=this.components.data||(this.components.data=[]),P=this.getFromEnv("chart"),w=this.config,T=this.config.JSONData,S=P.getFromEnv("dataSource").chart,k=T.data||[],C=k.length,E=this.getFromEnv("number-formatter"),M=(0,r.parseUnsafeString)(S.yaxisname),_=(0,r.parseUnsafeString)(S.xaxisname),F=w.lineDashed,I=w.lineDashStyle,N=(0,r.pluckNumber)(T.showregressionline,P.config.showregressionline,0),D=(0,r.pluckNumber)(T.showyonx,S.showyonx,1),A=w.parentYAxis,R=w.toolTipSepChar,V=w.seriesname;for(t=0;t<C;t+=1)i=k[t],(e=(o=b[t]||(b[t]={})).config||(o.config={})).setValue=n={x:E.getCleanValue(i.x),y:E.getCleanValue(i.y),index:t},v<n.x&&(v=n.x,w.rightMostData=o),y>n.x&&(y=n.x,w.leftMostData=o),m=Math.max(m,n.y),x=Math.min(x,n.y),w.showRegressionLine&&this.pointValueWatcher(n.x,n.y,w.regressionObj),e.setLink=(0,r.pluck)(i.link),e.anchorProps=this._parseAnchorProperties(t),e.showValue=(0,r.pluckNumber)(i.showvalue,w.showValues),e.dashed=(0,r.pluckNumber)(i.dashed,F),e.color=(0,r.pluck)(i.color,w.lineColor),e.alpha=(0,r.pluck)(i.alpha,w.lineAlpha),e.dashStyle=e.dashed?I:"none",e.toolTipValue=l=E.dataLabels(n.y,A),e.setDisplayValue=u=(0,r.parseUnsafeString)(i.displayvalue),g=e.formatedVal=(0,r.pluck)(i.toolTipValue,E.dataLabels(n.y,A)),d=E.xAxis(n.x),e.displayValue=(0,r.pluck)(u,l),e.setTooltext=(0,r.getValidValue)((0,r.parseUnsafeString)((0,r.pluck)(i.tooltext,w.plotToolText))),w.showTooltip?void 0!==e.setTooltext?(c=[4,5,6,7,8,9,10,11],h={yaxisName:M,xaxisName:_,yDataValue:g,xDataValue:d},a=(0,r.parseTooltext)(e.setTooltext,c,h,i,S,T)):null===g?a=!1:(a=V?V+R:r.BLANKSTRING,a+=n.x?d+R:r.BLANKSTRING,a+=l):a=!1,e.toolText=a,o?o.graphics||(b[t].graphics={}):o=b[t]={graphics:{}},e.hoverEffects=this._parseHoverEffectOptions(o),e.anchorProps.isAnchorHoverRadius=e.hoverEffects.anchorRadius;w.xMax=v,w.xMin=y,w.yMin=x,w.yMax=m,w.regressionPoints=N?(0,s["default"])(T.data.slice(),D)[1]:[],this.ErrorValueConfigure&&this.ErrorValueConfigure()},e}(i["default"]);e["default"]=S}}])});
//# sourceMappingURL=http://localhost:3052/3.13.5-rc.2/map/eval/fusioncharts.zoomscatter.js.map