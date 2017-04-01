/**
 * Created by kale on 2017/3/9.
 */
function start() {
    d3.select("body")
        .append("p")
        .text("load text with d3.js! today");
}
function echarts1() {
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title: {
            text: 'Echarts '
        },
        tooltip: {},
        legend: {
            data: ['销量', 'GDP'],
            selected: {
                '销量': true,
                'GDP': false
            }
        },
        xAxis: {
            data: ['shirt', 'blouse', 't-shirt', 'jean']
        },
        yAxis: {},
        dataZoom: [{
            type: 'slider',
            start: 10,
            end: 60
        }, {
            type: 'inside',
            start: 10,
            end: 60
        }],
        series: [{
            name: '销量',
            type: 'bar',
            data: [12, 85.199, 1]
        }, {
            name: 'GDP',
            type: 'bar',
            data: [12, 6.2, 1]
        }]
    };
    myChart.setOption(option);
    myChart.on('click', function (params) {
        console.log(params.name);
    })
}
function svgExample() {
    var canvas = d3.select("body")
        .append("svg")
        .attr("width", 700)
        .attr("height", 700);

    var circle = canvas.append("circle")
        .attr("cx", 10)
        .attr("cy", 10)
        .attr("r", 50)
        .attr("fill", "blue");

    var rectangle = canvas.append("rect")
        .attr("width", 500)
        .attr("height", 200);

    var line = canvas.append("line")
        .attr("x1", 0)
        .attr("x2", 200)
        .attr("y1", 200)
        .attr("y2", 600)
        .attr("stroke", "grey")
        .attr("stroke-width", 5);
}

function visualizeOranges() {
    var orangeData = [10, 30, 50, 100];

    var canvas = d3.select(".orangeContainer")
        .append("svg")
        .attr("width", 768)
        .attr("height", 1024)

    var oranges = canvas.selectAll("circle")
        .data(orangeData)
        .enter()
        .append("circle")
        .attr("fill", "orange")
        .attr("cx", function (d, i) {
            return d + (i * 100);
        })
        .attr("cy", function (d) {
            return d;
        })
        .attr("r", function (d) {
            return d;
        });
}

function scaling() {
    var graphData = [10, 1200],
        w = 200,
        h = 800;

    var scaling = d3.scaleLinear()
        .domain([0, 1200])
        .range([0, w]);

    var canvas = d3.select(".graphContainer")
        .append("svg")
        .attr("width", w)
        .attr("height", h);

    var graphBars = canvas.selectAll("rect")
        .data(graphData)
        .enter()
        .append("rect")
        .attr("fill", "pink")
        .attr("width", function (d) {
            return scaling(d);
        })
        .attr("height", 20)
        .attr("y", function (d, i) {
            return i * 50;
        })
}

function axisGroups() {
    var graphData = [10, 1200],
        w = 500,
        h = 800;


    var scaling = d3.scaleLinear()
        .domain([0, 1200])
        .range([0, w]);

    var axis = d3.axisBottom()
        .ticks(5)
        .scale(scaling);

    var canvas = d3.select(".graphContainer")
        .append("svg")
        .attr("width", w)
        .attr("height", h)
        .append("g")
        .attr("transform", "translate(20,50)");

    var graphBars = canvas.selectAll("rect")
        .data(graphData)
        .enter()
        .append("rect")
        .attr("fill", "pink")
        .attr("width", function (d) {
            return scaling(d);
        })
        .attr("height", 20)
        .attr("y", function (d, i) {
            return i * 50;
        });

    canvas.append("g")
        .attr("transform", "translate(0,200)")
        .call(axis);
}

function enterExamlpes() {
    var Data = [200, 100],
        w = 800,
        h = 600;
    var canvas = d3.select(".graphContainer")
        .append("svg")
        .attr("width", w)
        .attr("height", h);

    var box = canvas.append("rect")
        .attr("width", 300)
        .attr("height", 300)
        .attr("fill", "red");

    var boxes = canvas.selectAll("rect")
        .attr("fill", "purple")
        .exit()
        .data(Data)
    /*.enter()
     .append("rect")
     .attr("width",function (d) {
     return d;
     })
     .attr("height",function (d) {
     return d;
     })
     .attr("fill","grey")
     .attr("stroke","black");*/
}

function transitions() {
    var w = 800,
        h = 600;

    var canvas = d3.select(".transitionsContainer")
        .append("svg")
        .attr("width", w)
        .attr("height", h);

    var rect = canvas.append("rect")
        .attr("width", 100)
        .attr("height", 100)
        .attr("fill", "red");

    var circle = canvas.append("circle")
        .attr("cx", 50)
        .attr("cy", 200)
        .attr("r", 50)
        .attr("fill", "blue");

    circle.transition()
        .duration(2000)
        .delay(4000)
        .attr("cx", 200)
        .on("end", function () {
            d3.select(this)
                .attr("fill", "orange");
        });

    rect.transition()
        .duration(3000)
        .delay(2000)
        .attr("width", 200)
        .attr("transform", "translate(200,0)")
        .transition()
        .attr("transform", "translate(200,200)")

}

//绘制饼图
function pie() {
    var w = 800,
        h = 600;
    var outerRadius = w / 4,
        innerRadius = 0;

    var color = d3.scaleOrdinal(d3.schemeCategory10);

    var dataset = [30, 10, 43, 55, 13];

    var pie = d3.pie();

    var piedata = pie(dataset);

    var arc = d3.arc()
        .innerRadius(innerRadius)
        .outerRadius(outerRadius);

    var svg = d3.select(".pieContainer")
        .append("svg")
        .attr("width", w)
        .attr("height", h);

    var arcs = svg.selectAll("g")
        .data(piedata)
        .enter()
        .append("g")
        .attr("transform", "translate(" + (w / 2) + "," + (w / 2) + ")");

    arcs.append("path")
        .attr("fill", function (d, i) {
            return color(i);
        })
        .attr("d", function (d) {
            return arc(d);
        });


    arcs.append("text")
        .attr("transform", function (d) {
            return "translate(" + arc.centroid(d) + ")";
        })
        .attr("text-anchor", "middle")
        .text(function (d) {
            return d.data;
        })
}
//柱状图
function histogram() {
    var rand = d3.randomNormal(0, 25);
    var dataset = [];
    for (var i = 0; i < 100; i++) {
        dataset.push(rand());
    }
    var bin_num = 15;
    var histogram = d3.histogram()
        .thresholds(bin_num);

    var data = histogram(dataset);

    var max_height = 400;
    var rect_step = 30;
    var heights = [];
    for (var i = 0; i < data.length; i++) {
        heights.push(data[i].x1);
    }
    var yScale = d3.scaleLinear()
        .domain([d3.min(heights), d3.max(heights)])
        .range([0, max_height]);

    var svg = d3.select(".pieContainer")
        .append("svg")
        .attr("width", 800)
        .attr("height", 600);

    //绘制图形
    var graphics = svg.append("g")
        .attr("transform", "translate(30,20)");

//绘制矩形
    graphics.selectAll("rect")
        .data(data)
        .enter()
        .append("rect")
        .attr("x", function (d, i) {
            return i * rect_step;
        })
        .attr("y", function (d, i) {
            return max_height - yScale(d.x1);
        })
        .attr("width", function (d, i) {
            return rect_step - 2;
        })
        .attr("height", function (d) {
            return yScale(d.x1);
        })
        .attr("fill", "steelblue");

//绘制坐标轴的直线
    graphics.append("line")
        .attr("stroke", "black")
        .attr("stroke-width", "1px")
        .attr("x1", 0)
        .attr("y1", max_height)
        .attr("x2", data.length * rect_step)
        .attr("y2", max_height);

//绘制坐标轴的分隔符直线
    graphics.selectAll(".linetick")
        .data(data)
        .enter()
        .append("line")
        .attr("stroke", "black")
        .attr("stroke-width", "1px")
        .attr("x1", function (d, i) {
            return i * rect_step + rect_step / 2;
        })
        .attr("y1", max_height)
        .attr("x2", function (d, i) {
            return i * rect_step + rect_step / 2;
        })
        .attr("y2", max_height + 5);

//绘制文字
    graphics.selectAll("text")
        .data(data)
        .enter()
        .append("text")
        .attr("font-size", "10px")
        .attr("x", function (d, i) {
            return i * rect_step;
        })
        .attr("y", function (d, i) {
            return max_height;
        })
        .attr("dx", rect_step / 2 - 8)
        .attr("dy", "15px")
        .text(function (d) {
            return Math.floor(d.x0);
        });
}

//中国地图
function chinaMap(url) {
    var width = 1000;
    var height = 1000;

    var svg = d3.select(".chinamap").append("svg")
        .attr("width", width)
        .attr("height", height)
        .append("g")
        .attr("transform", "translate(0,0)");

    svg.selectAll("p")
        .text("china map")
        .append("p")
        .attr("x", 100)
        .attr("y", 100);

    var projection = d3.geoMercator()
        .center([107, 31])
        .scale(850)
        .translate([width / 2, height / 2]);

    var path = d3.geoPath()
        .projection(projection);

    // var dataset = [ 2.5 , 2.1 , 1.7 , 1.3 , 0.9 ];

    var linear = d3.scaleLinear()
        .domain([0, 34])
        .range([0, 20]);

    var color = d3.scaleOrdinal(d3.schemeCategory20c);

    d3.json(url, function (error, root) {

        if (error)
            return console.error(error);
        console.log(root.features);

        svg.selectAll("path")
            .data(root.features)
            .enter()
            .append("path")
            .attr("stroke", "#000")
            .attr("stroke-width", 1)
            .attr("fill", function (d, i) {
                return color(linear(i));
            })
            .attr("d", path)   //使用地理路径生成器
            .on("mouseover", function (d, i) {
                d3.select(this)
                    .attr("fill", "yellow");
                d3.select("#main").append("p")
                    .text(d.properties.name + d.properties.id);
            })
            .on("mouseout", function (d, i) {
                d3.select(this)
                    .attr("fill", color(i));
                var p = d3.select("#main").selectAll("p");
                p.remove();
            })
            .on("click", function (d, i) {
                var centroid=path.centroid(d);
                d3.select(this)
                    .attr("fill", "red");

                $.ajax({
                    url: '/query/alarmNum?cityName=zhejiang',
                    type: 'GET',
                    dataType: 'json',
                    timeout: 1000,
                    cache: false,
                    error: errorFunction,
                    success: successFunction
                });

                function errorFunction() {
                    alert("error");
                }

                function successFunction(tt) {
                    d3.select("#middle").append("d")
                        .text(tt.length)
                }

            });

        svg.selectAll("text")
            .data(root.features)
            .enter()
            .append("text")
            .attr("font-size",10)
            .attr("x",function (d,i) {
                var centroid=path.centroid(d);
                return centroid[0];
            })
            .attr("y",function (d,i) {
                var centroid=path.centroid(d);
                return centroid[1];
            })
            .attr("dx","-5px")
            .attr("dy","5px")
            .text(function (d,i) {
                return d.properties.name;
            })

    });


}