{
  "chart": {
      "caption": "Product-wise Quarterly Revenue vs. Profit %",
      "subCaption": "Harry's SuperMart - Last Year",
      "xAxisname": "Quarter",
      "pYAxisName": "Sales",
      "sYAxisName": "Profit %",
      "numberPrefix": "$",
      "sNumberSuffix": "%",
      "sYAxisMaxValue": "25",
      "theme": "fusion",
      "exportenabled": 1,
      "enableChartMouseMoveEvent": 1,
      //External image url path for logo
      "logoURL": "http://static.fusioncharts.com/sampledata/images/Logo-HM-72x72.png",
      //Changing logo alpha
      "logoAlpha": "40",
      //Scaling logo image
      "logoScale": "110",
      //Setting logo position
      "logoPosition": "TR"
  },
  "categories": [{
      "category": [{
              "label": "Q1"
          },
          {
              "label": "Q2"
          },
          {
              "label": "Q3"
          },
          {
              "label": "Q4"
          }
      ]
  }],
  "dataset": [{
          "seriesname": "Food Products",
          "data": [{
                  "value": "10000"
              },
              {
                  "value": "15000"
              },
              {
                  "value": "2000"
              },
              {
                  "value": "15000"
              }
          ]
      },
      {
          "seriesname": "Non-Food Products",
          "data": [{
                  "value": "3000"
              },
              {
                  "value": "3400"
              },
              {
                  "value": "9000"
              },
              {
                  "value": "11800"
              }
          ]
      },
      {
          "seriesname": "Profit %",
          "renderAs": "line",
          "parentYAxis": "S",
          "showValues": "0",
          "data": [{
                  "value": "14"
              },
              {
                  "value": "16"
              },
              {
                  "value": "15"
              },
              {
                  "value": "17"
              }
          ]
      }
  ]
}