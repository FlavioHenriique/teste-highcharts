var client = new XMLHttpRequest();

client.open('GET', 'http://localhost:8080/Highcharts/api/empenho/array', false);
client.send(null);
console.log(client.status);
if (client.status == 200) {
    categorias = client.responseText.split(",");
}

client.open('GET', 'http://localhost:8080/Highcharts/api/empenho/grafico', false);
client.send(null);
console.log(client.status);
if (client.status == 200) {
    var series = JSON.parse(client.responseText);
}
Highcharts.chart('container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Testando highcharts'
    },
    subtitle: {
        text: "ok"
    },
    xAxis: {
        categories: categorias,
        title: {
            text: "FUNÇÕES"
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Valor',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    },
    tooltip: {
        valueSuffix: ' millions'
    },
    plotOptions: {
        bar: {
            dataLabels: {
                enabled: false
            }
        }
    },
    legend: {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'top',
        x: -40,
        y: 80,
        floating: true,
        borderWidth: 1,
        //backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
        shadow: true
    },
    credits: {
        enabled: false
    },
    series: series/*[{
     name: 'Ano 2010',
     data: [107, 100, 635, 203, 2]
     }, {
     name: 'Ano 2011',
     data: [133, 156, 947, 408, 6]
     }, {
     name: 'Ano 2012',
     data: [100, 200, 300, 400, 500]
     }, {
     name: 'Ano 2013',
     data: [1216, 1001, 4436, 738, 40]
     }]*/

});