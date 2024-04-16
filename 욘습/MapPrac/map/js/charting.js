// JS 
var chart = JSC.chart('chartDiv', { 
    debug: true, 
    type: 'map', 
    legend_visible: false, 
    
    title: { 
      position: 'full', 
      label_text: 'World Regions Projections'
    }, 
    
    mapping_projection: false, 
    
    series: [ 
      { 
        /* 
         * The world must be specified in order to load the correct map. This however only needs to be specified once. 
         * Alternatively, setting mappingReferenceLayer to world also works. 
         * */
        map: 'world.region:africa'
      }, 
      { map: 'region:europe' }, 
      { map: 'region:asia' }, 
      { map: 'region:americas' } 
    ], 
    toolbar: { 
      items: { 
        resetZoom_position: 'inside bottom left', 
        Projection: { 
          type: 'select', 
          value: 'none', 
          items: { 
            none: {}, 
            mercator: {}, 
            lambertConformalConic: {} 
          }, 
          events_change: projectionChanged 
        } 
      } 
    } 
  }); 
    
  function projectionChanged(val) { 
    chart.options({ 
      mapping_projection: { 
        type: val, 
        parallels: [11.5, 0] 
      } 
    }); 
  } 
    
  function setProjection(val) { 
    chart.options({ mapping_projection_type: val }); 
  } 