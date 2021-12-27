function sendFormatRequest(event) {
    jQuery.ajax({
        url: '/simpledateformat/format',
        data: { pattern: jQuery('#inputFormat').val()},
        success: function(result) {
            jQuery('#result').text(result.value);
        }
    });
}