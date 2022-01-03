function sendFormatRequest(url) {
	let locale = jQuery('#inputLocale').val();
	let colonIndex = locale.indexOf(':');
	if (colonIndex != -1) {
		locale = locale.substring(0, colonIndex);
	}
	
    jQuery.ajax({
        url: url,
        data: { pattern: jQuery('#inputFormat').val(),
                locale: locale,
                timeZone: jQuery('#inputTimeZone').val() },
        success: function(result) {
            jQuery('#result').text(result.value);
            if (result.error) {
                jQuery('#result').addClass('error');
            } else {
                jQuery('#result').removeClass('error');
            }
        }
    });
}

function sendParseRequest(url) {
	let locale = jQuery('#inputLocale').val();
	let colonIndex = locale.indexOf(':');
	if (colonIndex != -1) {
		locale = locale.substring(0, colonIndex);
	}
	
    jQuery.ajax({
        url: url,
        data: { pattern: jQuery('#inputFormat').val(),
				text: jQuery('#inputText').val(),
                locale: locale,
                timeZone: jQuery('#inputTimeZone').val() },
        success: function(result) {
            jQuery('#result').text(result.value);
            if (result.error) {
                jQuery('#result').addClass('error');
            } else {
                jQuery('#result').removeClass('error');
            }
        }
    });
}

function sendHashGenerateRequest() {
	    jQuery.ajax({
        url: 'hash/generate',
        data: { text: jQuery('#inputText').val() },
        success: function(result) {
            jQuery('#md5result').val(result.MD5);
			jQuery('#sha1result').val(result.SHA1);
			jQuery('#sha256result').val(result.SHA_256);
			jQuery('#sha512result').val(result.SHA_512);
        }
    });
}

function copyText(id) {
	 navigator.clipboard.writeText(jQuery('#' + id).val());
}